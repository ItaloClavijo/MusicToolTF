package pe.edu.upc.musictooltf.Services;

import pe.edu.upc.musictooltf.DTOs.paypalDTO.OrderCaptureResponse;
import pe.edu.upc.musictooltf.DTOs.paypalDTO.OrderResponse;

public interface PaypalService {

    public OrderResponse createOrder(Integer purchaseId, String returnUrl, String cancelUrl);

    public OrderResponse createOrderSub(Integer subId, String returnUrl, String cancelUrl);

    public OrderCaptureResponse captureOrder(String orderId);
}
