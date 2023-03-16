package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SalesReport {
    private String totalSales;
    private String netSales;
    private String averageSales;
    private Integer totalOrders;
    private Integer totalItems;
    private String totalTax;
    private String totalShipping;
    private Integer totalRefunds;
    private String totalDiscount;
    private String totalsGroupedBy;
    private Totals totals;
    private Integer totalCustomers;
    @JsonProperty("_links")
    private Links links;
}