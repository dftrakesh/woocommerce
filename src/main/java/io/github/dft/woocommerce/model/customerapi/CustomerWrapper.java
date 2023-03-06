package io.github.dft.woocommerce.model.customerapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerWrapper extends ArrayList<Customer> {
}
