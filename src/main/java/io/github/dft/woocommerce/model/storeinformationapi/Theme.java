package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Theme {
    private String name;
    private String version;
    private String versionLatest;
    private String authorUrl;
    private Boolean isChildTheme;
    private Boolean hasWoocommerceSupport;
    private Boolean hasWoocommerceFile;
    private Boolean hasOutdatedTemplates;
    private String parentName;
    private String parentVersion;
    private String parentVersionLatest;
    private String parentAuthorUrl;
    private List<Object> overrides;
}