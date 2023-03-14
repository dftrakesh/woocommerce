package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesReportTotals {
    private String sales;
    private Integer orders;
    private Integer items;
    private String tax;
    private String shipping;
    private String discount;
    private Integer customers;
}
