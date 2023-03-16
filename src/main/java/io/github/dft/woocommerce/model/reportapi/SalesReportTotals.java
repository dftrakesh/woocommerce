package io.github.dft.woocommerce.model.reportapi;

import lombok.Data;

@Data

public class SalesReportTotals {
    private String sales;
    private Integer orders;
    private Integer items;
    private String tax;
    private String shipping;
    private String discount;
    private Integer customers;
}