package io.github.dft.woocommerce.model.orderapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import io.github.dft.woocommerce.model.customerapi.Billing;
import io.github.dft.woocommerce.model.customerapi.MetaData;
import io.github.dft.woocommerce.model.customerapi.Shipping;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order {
    private int id;
    @JsonProperty("_links")
    private Links link;
    private String total;
    private int parentId;
    private String number;
    private String status;
    private String cartTax;
    private String version;
    private int customerId;
    private Billing billing;
    private String orderKey;
    private String totalTax;
    private String currency;
    private boolean setPaid;
    private String cartHash;
    private Shipping shipping;
    private String createdVia;
    private String discountTax;
    private String shippingTax;
    private List<Refund> refunds;
    private String customerNote;
    private String transactionId;
    private String discountTotal;
    private String shippingTotal;
    private String paymentMethod;
    private List<FeeLine> feeLines;
    private List<TaxLine> taxLines;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime datePaid;
    private List<MetaData> metaData;
    private List<LineItem> lineItems;
    private boolean pricesIncludeTax;
    private String customerIpAddress;
    private String customerUserAgent;
    private String paymentMethodTitle;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime datePaidGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreated;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModified;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCompleted;
    private List<CouponLine> couponLines;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModifiedGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCompletedGmt;
    private List<ShippingLine> shippingLines;
    private String currencySymbol;

}
