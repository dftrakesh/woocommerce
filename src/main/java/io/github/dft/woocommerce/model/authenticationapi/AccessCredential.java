package io.github.dft.woocommerce.model.authenticationapi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccessCredential {
    private String storeDomain;
    private String keyId;
    private String userId;
    private String consumerKey;
    private String consumerSecret;
    private String keyPermissions;
}
