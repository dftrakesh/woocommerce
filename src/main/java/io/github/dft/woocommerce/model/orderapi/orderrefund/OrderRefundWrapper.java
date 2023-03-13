package io.github.dft.woocommerce.model.orderapi.orderrefund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRefundWrapper extends ArrayList<OrderRefund> {
}
