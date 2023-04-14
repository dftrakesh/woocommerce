package io.github.dft.woocommerce.model.authenticationapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccessCredential {
    private String storeDomain;
    private String keyId;
    private String userId;
    private String consumerKey;
    private String consumerSecret;
    private String keyPermissions;
}
