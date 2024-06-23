package pe.edu.upc.musictooltf.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalCaptureResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.PaypalOrderResponse;
import pe.edu.upc.musictooltf.ServiceImplements.CheckoutService;

@AllArgsConstructor
@RestController
@RequestMapping("/musictool/checkout")
@CrossOrigin(origins = "http://localhost:4200")
public class PaypalCheckoutController {

    private CheckoutService checkoutService ;

    @PostMapping("/paypal/create")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public PaypalOrderResponse createPaypalOrder(
            @RequestParam Integer purchaseId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl
    ) {
       return checkoutService.createPaypalPaymentUrl(purchaseId,returnUrl,cancelUrl);
    }

    @PostMapping("/paypal/create/sub")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public PaypalOrderResponse createPaypalSubOrder(
            @RequestParam Integer subId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl
    ) {
        return checkoutService.createPaypalPaymentSubUrl(subId,returnUrl,cancelUrl);
    }

    @PostMapping("/paypal/capture")
    @PreAuthorize("hasAuthority('MELOMANO') || hasAuthority('ADMIN')")
    public PaypalCaptureResponse capturePaypalOrder(@RequestParam String orderId) {
        return checkoutService.capturePaypalPayment(orderId);
    }

}
