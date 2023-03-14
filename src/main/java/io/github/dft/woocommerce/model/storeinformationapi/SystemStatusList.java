package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SystemStatusList extends ArrayList<StoreInformation> {
}
