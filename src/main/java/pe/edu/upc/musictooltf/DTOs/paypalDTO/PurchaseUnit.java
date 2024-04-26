package pe.edu.upc.musictooltf.DTOs.paypalDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseUnit {
    @JsonProperty("reference_id")
    private String referenceId;

    private Amount amount;
}

