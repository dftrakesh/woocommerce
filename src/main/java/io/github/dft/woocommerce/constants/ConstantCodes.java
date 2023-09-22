package io.github.dft.woocommerce.constants;

import java.util.HashMap;
import java.util.Map;

public interface ConstantCodes {
    Map<String, String> TRACKING_PROVIDER_LINK_MAP = new HashMap<>(){
        {
            put("EKART", "https://ekartlogistics.com/shipmenttrack/{trackingNumber}");
            put("SHADOWFAX", "https://tracker.shadowfax.in/");
        }
    };
}