package io.github.dft.woocommerce.model.productapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.DateDeserializer;
import io.github.dft.woocommerce.model.customerapi.MetaData;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {
    private Integer id;
    private String sku;
    @JsonProperty("_links")
    private Links links;
    private String name;
    private String slug;
    private String type;
    private Integer parentId;
    private List<Image> images;
    private String price;
    private String weight;
    private Integer menuOrder;
    private String status;
    private List<Tag> tags;
    private Integer totalSales;
    private Boolean onSale;
    private Integer ratingCount;
    private Boolean virtual;
    private String taxClass;
    private boolean visible;
    private Boolean inStock;
    private String priceHtml;
    private Boolean featured;
    private String salePrice;
    private String permalink;
    private String taxStatus;
    private String buttonText;
    private Integer stockQuantity;
    private String backorders;
    private Integer downloadLimit;
    private String externalUrl;
    private Integer downloadExpiry;
    private String description;
    private Boolean backOrdered;
    private String purchaseNote;
    private String regularPrice;
    private Integer shippingClassId;
    private Boolean manageStock;
    private Boolean purchasable;
    private String averageRating;
    private Boolean downloadable;
    private Dimension dimensions;
    private String shippingClass;
    private Boolean reviewsAllowed;
    private List<MetaData> metaData;
    private Boolean shippingTaxable;
    private List<Integer> upsellIds;
    private String shortDescription;
    private String catalogVisibility;
    private Boolean soldIndividually;
    private Boolean shippingRequired;
    private List<Integer> relatedIds;
    private List<Integer> variations;
    private List<Download> downloads;
    private List<Category> categories;
    private Boolean backOrdersAllowed;
    @JsonDeserialize(using=DateDeserializer.class)
    private LocalDateTime dateCreated;
    private List<Attribute> attributes;
    private List<Integer> crossSellIds;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleTo;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModified;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleFrom;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateCreatedGmt;
    private List<Integer> groupedProducts;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateModifiedGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleToGmt;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime dateOnSaleFromGmt;
    private List<DefaultAttribute> defaultAttributes;
}
