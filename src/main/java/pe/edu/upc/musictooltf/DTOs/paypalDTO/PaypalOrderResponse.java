package pe.edu.upc.musictooltf.DTOs.paypalDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaypalOrderResponse {
    private String paypalUrl;
}