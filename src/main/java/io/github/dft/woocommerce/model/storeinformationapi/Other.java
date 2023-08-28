package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.github.dft.woocommerce.model.common.CombineDatabaseTables;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Other {
    private CombineDatabaseTables wp2bActionschedulerActions;
    private CombineDatabaseTables wp2bActionschedulerClaims;
    private CombineDatabaseTables wp2bActionschedulerGroups;
    private CombineDatabaseTables wp2bActionschedulerLogs;
    private CombineDatabaseTables wp2bCommentmeta;
    private CombineDatabaseTables wp2bComments;
    private CombineDatabaseTables wp2bLinks;
    private CombineDatabaseTables wp2bOptions;
    private CombineDatabaseTables wp2bPostmeta;
    private CombineDatabaseTables wp2bPosts;
    private CombineDatabaseTables wp2bTermmeta;
    private CombineDatabaseTables wp2bTerms;
    private CombineDatabaseTables wp2bTermRelationships;
    private CombineDatabaseTables wp2bTermTaxonomy;
    private CombineDatabaseTables wp2bUsermeta;
    private CombineDatabaseTables wp2bUsers;
    private CombineDatabaseTables wp2bWcAdminNotes;
    private CombineDatabaseTables wp2bWcAdminNoteActions;
    private CombineDatabaseTables wp2bWcCategoryLookup;
    private CombineDatabaseTables wp2bWcCustomerLookup;
    private CombineDatabaseTables wp2bWcDownloadLog;
    private CombineDatabaseTables wp2bWcOrderCouponLookup;
    private CombineDatabaseTables wp2bWcOrderProductLookup;
    private CombineDatabaseTables wp2bWcOrderStats;
    private CombineDatabaseTables wp2bWcOrderTaxLookup;
    private CombineDatabaseTables wp2bWcProductMetaLookup;
    private CombineDatabaseTables wp2bWcRateLimits;
    private CombineDatabaseTables wp2bWcReservedStock;
    private CombineDatabaseTables wp2bWcTaxRateClasses;
    private CombineDatabaseTables wp2bWcWebhooks;
    private CombineDatabaseTables wp2bEwwwioImages;
    private CombineDatabaseTables wp2bEwwwioQueue;
    private CombineDatabaseTables wp2bWcProductAttributesLookup;
    private CombineDatabaseTables wp2bWcProductDownloadDirectories;
}