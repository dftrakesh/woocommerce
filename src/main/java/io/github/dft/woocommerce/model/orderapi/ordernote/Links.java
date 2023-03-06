package io.github.dft.woocommerce.model.orderapi.ordernote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.woocommerce.model.customerapi.Collection;
import io.github.dft.woocommerce.model.customerapi.Self;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private List<Up> up;
    private List<Self> self;
    private List<Collection> collection;
}
