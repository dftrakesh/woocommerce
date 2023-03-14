package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Settings {
    private Boolean apiEnabled;
    private Boolean forceSsl;
    private String currency;
    private String currencySymbol;
    private String currencyPosition;
    private String thousandSeparator;
    private String decimalSeparator;
    private Long numberOfDecimals;
    private Boolean geolocationEnabled;
    private Taxonomies taxonomies;
    private ProductVisibilityTerms productVisibilityTerms;
    private String woocommerceComConnected;
}