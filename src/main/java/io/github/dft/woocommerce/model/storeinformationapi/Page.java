package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Page {
    private String pageName;
    private String pageId;
    private Boolean pageSet;
    private Boolean pageExists;
    private Boolean pageVisible;
    private String shortcode;
    private String block;
    private Boolean shortcodeRequired;
    private Boolean shortcodePresent;
    private Boolean blockPresent;
    private Boolean blockRequired;
}