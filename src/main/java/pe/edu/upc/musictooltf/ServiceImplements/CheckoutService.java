package pe.edu.upc.musictooltf.ServiceImplements;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.OrderCaptureResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.OrderResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalCaptureResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalOrderResponse;
import pe.edu.upc.musictooltf.Entities.Purchase;
import pe.edu.upc.musictooltf.Services.IPurchaseService;
import pe.edu.upc.musictooltf.Services.PaypalService;

@AllArgsConstructor
@Service
public class CheckoutService {

    private PaypalService paypalService;
    private IPurchaseService purchaseService;

    public PaypalOrderResponse createPaypalPaymentUrl(Integer purchaseId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = paypalService.createOrder(purchaseId, returnUrl, cancelUrl);

        String paypalUrl = orderResponse
                .getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approve"))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getHref();

        return new PaypalOrderResponse(paypalUrl);
    }

    public PaypalOrderResponse createPaypalPaymentSubUrl(Integer subId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = paypalService.createOrderSub(subId, returnUrl, cancelUrl);

        String paypalUrl = orderResponse
                .getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approve"))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getHref();

        return new PaypalOrderResponse(paypalUrl);
    }

    public PaypalCaptureResponse capturePaypalPayment(String orderId) {
        OrderCaptureResponse orderCaptureResponse = paypalService.captureOrder(orderId);
        boolean completed = orderCaptureResponse.getStatus().equals("COMPLETED");

        PaypalCaptureResponse paypalCaptureResponse = new PaypalCaptureResponse();
        paypalCaptureResponse.setCompleted(completed);

        if (completed) {
            String purchaseIdStr = orderCaptureResponse.getPurchaseUnits().get(0).getReferenceId();
            Purchase purchase = purchaseService.updateToPaid(Integer.parseInt(purchaseIdStr));
            paypalCaptureResponse.setPurchaseId(purchase.getIdPurchase());
        }
        return paypalCaptureResponse;
    }

}
