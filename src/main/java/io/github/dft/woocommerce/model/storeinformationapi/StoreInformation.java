package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StoreInformation {
    private Environment environment;
    private Database database;
    private List<ActivePlugin> activePlugins;
    private List<InactivePlugin> inactivePlugins;
    private Theme theme;
    private Settings settings;
    private Security security;
    private List<Page> pages;
    private List<PostTypeCount> postTypeCounts;
    private DropinsMuPlugins dropinsMuPlugins;
}
