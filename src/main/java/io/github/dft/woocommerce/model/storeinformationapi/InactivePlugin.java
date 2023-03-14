package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InactivePlugin {
    private String plugin;
    private String name;
    private String version;
    private String versionLatest;
    private String url;
    private String authorName;
    private String authorUrl;
    private Boolean networkActivated;
}