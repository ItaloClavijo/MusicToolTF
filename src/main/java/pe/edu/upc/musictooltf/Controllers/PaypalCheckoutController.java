package pe.edu.upc.musictooltf.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalCaptureResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalOrderResponse;
import pe.edu.upc.musictooltf.ServiceImplements.CheckoutService;

@AllArgsConstructor
@RestController
@RequestMapping("/musictool/checkout")
public class PaypalCheckoutController {

    private CheckoutService checkoutService ;

    @PostMapping("/paypal/create")
    public PaypalOrderResponse createPaypalOrder(
            @RequestParam Integer purchaseId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl
    ) {
       return checkoutService.createPaypalPaymentUrl(purchaseId,returnUrl,cancelUrl);
    }

    @PostMapping("/paypal/create/sub")
    public PaypalOrderResponse createPaypalSubOrder(
            @RequestParam Integer subId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl
    ) {
        return checkoutService.createPaypalPaymentSubUrl(subId,returnUrl,cancelUrl);
    }

    @PostMapping("/paypal/capture")
    public PaypalCaptureResponse capturePaypalOrder(@RequestParam String orderId) {
        return checkoutService.capturePaypalPayment(orderId);
    }

}
