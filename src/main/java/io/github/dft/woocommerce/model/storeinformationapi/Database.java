package io.github.dft.woocommerce.model.storeinformationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Database {
    private String wcDatabaseVersion;
    private String databasePrefix;
    private String maxmindGeoipDatabase;
    private DatabaseTables databaseTables;
    private DatabaseSize databaseSize;
}
