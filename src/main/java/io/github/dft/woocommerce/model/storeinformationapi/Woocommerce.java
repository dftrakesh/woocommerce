package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.CombineDatabaseTables;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Woocommerce {
    private CombineDatabaseTables wp2bWoocommerceSessions;
    private CombineDatabaseTables wp2bWoocommerceApiKeys;
    private CombineDatabaseTables wp2bWoocommerceAttributeTaxonomies;
    private CombineDatabaseTables wp2bWoocommerceDownloadableProductPermissions;
    private CombineDatabaseTables wp2bWoocommerceOrderItems;
    private CombineDatabaseTables wp2bWoocommerceOrderItemmeta;
    private CombineDatabaseTables wp2bWoocommerceTaxRates;
    private CombineDatabaseTables wp2bWoocommerceTaxRateLocations;
    private CombineDatabaseTables wp2bWoocommerceShippingZones;
    private CombineDatabaseTables wp2bWoocommerceShippingZoneLocations;
    private CombineDatabaseTables wp2bWoocommerceShippingZoneMethods;
    private CombineDatabaseTables wp2bWoocommercePaymentTokens;
    private CombineDatabaseTables wp2bWoocommercePaymentTokenmeta;
    private CombineDatabaseTables wp2bWoocommerceLog;
}