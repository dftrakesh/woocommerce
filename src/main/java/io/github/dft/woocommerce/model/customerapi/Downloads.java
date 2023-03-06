package io.github.dft.woocommerce.model.customerapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Downloads {
    private File file;
    private Integer orderId;
    private Links links;
    private Integer productId;
    private String orderKey;
    private String downloadId;
    private String downloadUrl;
    private String productName;
    private String downloadName;
    private String accessExpires;
    private String accessExpiresGmt;
    private String downloadsRemaining;
}
