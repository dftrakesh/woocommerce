package io.github.dft.woocommerce.model.orderapi.orderrefund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import io.github.dft.woocommerce.model.customerapi.MetaData;
import io.github.dft.woocommerce.model.orderapi.FeeLine;
import io.github.dft.woocommerce.model.orderapi.ShippingLine;
import io.github.dft.woocommerce.model.orderapi.TaxLine;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderRefund {
    private int id;
    private Double amount;
    private String reason;
    private Long refundedBy;
    private boolean apiRefund;
    private boolean refundedPayment;
    private List<MetaData> metaData;
    private List<LineItem> lineItems;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreated;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
    private List<ShippingLine> shippingLines;
    private List<TaxLine> taxLines;
    private List<FeeLine> feeLines;
    @JsonProperty("_links")
    private Links links;
}
