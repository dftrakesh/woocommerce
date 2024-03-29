package io.github.dft.woocommerce.model.customerapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Shipping {
    private String city;
    private String state;
    private String country;
    private String company;
    private String postcode;
    @JsonProperty("address_1")
    private String address1;
    @JsonProperty("address_2")
    private String address2;
    private String lastName;
    private String firstName;
    private String phone;
}
