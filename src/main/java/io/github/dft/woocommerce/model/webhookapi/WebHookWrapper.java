package io.github.dft.woocommerce.model.webhookapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHookWrapper extends ArrayList<WebHook> {
}
