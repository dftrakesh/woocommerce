package io.github.dft.woocommerce.model.updateinventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateInventory {
    private Integer stockQuantity;
    private String stockStatus;
    private Boolean manageStock;
}
