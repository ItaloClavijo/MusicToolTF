package pe.edu.upc.musictooltf.ServiceImplements;


import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.*;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Entities.Subscription;
import pe.edu.upc.musictooltf.Repositories.IPurchaseRepository;
import java.util.Base64;
import java.util.Collections;
import pe.edu.upc.musictooltf.Exceptions.ResourceNotFoundException;
import pe.edu.upc.musictooltf.Repositories.ISubscriptionRepository;
import pe.edu.upc.musictooltf.Services.PaypalService;

@RequiredArgsConstructor
@Service
public class PaypalServiceImplement implements PaypalService {

    @Value("${paypal.client-id}")
    private String clientId;

    @Value("${paypal.client-secret}")
    private String clientSecret;

    @Value("${paypal.api-base}")
    private String apiBase;

    @NonNull
    private IPurchaseRepository purchaseRepository;

    @NonNull
    private ISubscriptionRepository subscriptionRepository;


    private RestClient paypalClient;

    @PostConstruct
    public void init() {
        paypalClient = RestClient
                .builder()
                .baseUrl(apiBase)
                .build();
    }

    private String getAccessToken() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        return paypalClient.post()
                .uri("/v1/oauth2/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes()))
                .body(body)
                .retrieve()
                .toEntity(TokenResponse.class)
                .getBody()
                .getAccessToken();
    }


    public OrderResponse createOrder(Integer purchaseId, String returnUrl, String cancelUrl) {
        Purchase purchase = purchaseRepository
                .findById(purchaseId)
                .orElseThrow(ResourceNotFoundException::new);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setIntent("CAPTURE");

        Amount amount = new Amount();
        amount.setCurrencyCode("USD");
        amount.setValue(purchase.getPurchaseTotal().toString());

        PurchaseUnit purchaseUnit = new PurchaseUnit();
        purchaseUnit.setReferenceId(purchase.getIdPurchase().toString());
        purchaseUnit.setAmount(amount);

        orderRequest.setPurchaseUnits(Collections.singletonList(purchaseUnit));

        ApplicationContext applicationContext = ApplicationContext
                .builder()
                .brandName("Musictool")
                .returnURL(returnUrl)
                .cancelURL(cancelUrl)
                .build();

        orderRequest.setApplicationContext(applicationContext);

        return paypalClient.post()
                .uri("/v2/checkout/orders")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .body(orderRequest)
                .retrieve()
                .toEntity(OrderResponse.class)
                .getBody();
    }

    public OrderResponse createOrderSub(Integer subId, String returnUrl, String cancelUrl) {
        Subscription subscription = subscriptionRepository
                .findById(subId)
                .orElseThrow(ResourceNotFoundException::new);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setIntent("CAPTURE");

        Amount amount = new Amount();
        amount.setCurrencyCode("USD");
        amount.setValue(subscription.getTotalSubscription().toString());

        PurchaseUnit purchaseUnit = new PurchaseUnit();
        purchaseUnit.setReferenceId(subscription.getIdSubscription().toString());
        purchaseUnit.setAmount(amount);

        orderRequest.setPurchaseUnits(Collections.singletonList(purchaseUnit));

        ApplicationContext applicationContext = ApplicationContext
                .builder()
                .brandName("Musictool")
                .returnURL(returnUrl)
                .cancelURL(cancelUrl)
                .build();

        orderRequest.setApplicationContext(applicationContext);

        return paypalClient.post()
                .uri("/v2/checkout/orders")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .body(orderRequest)
                .retrieve()
                .toEntity(OrderResponse.class)
                .getBody();
    }

    public OrderCaptureResponse captureOrder(String orderId) {
        return paypalClient.post()
                .uri("v2/checkout/orders/{order_id}/capture", orderId)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(OrderCaptureResponse.class)
                .getBody();
    }
}

