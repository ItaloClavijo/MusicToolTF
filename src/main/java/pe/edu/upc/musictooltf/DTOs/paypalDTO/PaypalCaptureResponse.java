package pe.edu.upc.musictooltf.DTOs.paypalDTO;

import lombok.Data;

@Data
public class PaypalCaptureResponse {
    private boolean completed;
    private Integer purchaseId;
}
