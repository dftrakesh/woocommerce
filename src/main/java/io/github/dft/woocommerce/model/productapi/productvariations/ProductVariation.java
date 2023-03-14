package io.github.dft.woocommerce.model.productapi.productvariations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import io.github.dft.woocommerce.model.customerapi.MetaData;
import io.github.dft.woocommerce.model.productapi.Attribute;
import io.github.dft.woocommerce.model.productapi.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductVariation {
    private String id;
    private String sku;
    @JsonProperty("_links")
    private Links links;
    private Image images;
    private String price;
    private String weight;
    private int menuOrder;
    private Boolean onSale;
    private Boolean virtual;
    private String taxClass;
    private boolean visible;
    private Boolean inStock;
    private String salePrice;
    private String permalink;
    private String taxStatus;
    private int stockQuantity;
    private String backorders;
    private int downloadLimit;
    private int downloadExpiry;
    private String description;
    private Boolean backOrdered;
    private int shippingClassId;
    private String regularPrice;
    private String manageStock;
    private Boolean purchasable;
    private Boolean downloadable;
    private Dimension dimensions;
    private String shippingClass;
    private List<MetaData> metaData;
    private List<Download> downloads;
    private Boolean backOrdersAllowed;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreated;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleTo;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModified;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleFrom;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModifiedGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleToGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleFromGmt;
    private List<Attribute> attributes;
}