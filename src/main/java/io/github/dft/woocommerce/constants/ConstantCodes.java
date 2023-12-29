package io.github.dft.woocommerce.constants;

import java.util.HashMap;
import java.util.Map;

public interface ConstantCodes {
    Map<String, String> TRACKING_PROVIDER_LINK_MAP = new HashMap<>(){
        {
            put("AMAZON SHIPPING", "https://track.amazon.in/");
            put("BLUEDART", "https://bluedarttracking.in/");
            put("DELHIVERY", "https://www.delhivery.com/tracking");
            put("ECOM", "https://ecomexpress.in/tracking/");
            put("EKART", "https://ekartlogistics.com/shipmenttrack/{trackingNumber}");
            put("SHADOWFAX", "https://tracker.shadowfax.in/");
            put("SHREE-MARUTI", "https://www.shreemaruti.com/track-your-shipment");
            put("XPRESSBEES", "https://www.xpressbees.com/shipment/tracking");
        }
    };
}