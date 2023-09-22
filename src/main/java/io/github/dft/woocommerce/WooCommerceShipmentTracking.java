package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.shipmenttrackingapi.CustomTracking;
import io.github.dft.woocommerce.model.shipmenttrackingapi.Tracking;
import io.github.dft.woocommerce.model.shipmenttrackingapi.TrackingResponse;
import io.github.dft.woocommerce.model.shipmenttrackingapi.TrackingResponseList;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;
import static io.github.dft.woocommerce.constants.ConstantCodes.TRACKING_PROVIDER_LINK_MAP;

public class WooCommerceShipmentTracking extends WooCommerceSdk {

    private String SHIPMENT_TRACKING_ENDPOINT = "orders/orderId/shipment-trackings";

    public WooCommerceShipmentTracking(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public TrackingResponseList getShipmentTracking(String orderId) {
        URI uri = shipmentTrackingBaseUrl(SHIPMENT_TRACKING_ENDPOINT.replace("orderId", orderId));
        HttpRequest request = get(uri);

        return getRequestWrapped(request, TrackingResponseList.class);
    }

    @SneakyThrows
    public TrackingResponse createShipmentTracking(String orderId, Tracking tracking, boolean isCustomTrackingProvider) {
        URI uri = shipmentTrackingBaseUrl(SHIPMENT_TRACKING_ENDPOINT.replace("orderId", orderId));
        HttpRequest request = post(uri, getString(tracking));

        if (isCustomTrackingProvider) {
            String trackingProvider = tracking.getTrackingProvider();
            CustomTracking customTracking = new CustomTracking();
            customTracking.setTrackingNumber(tracking.getTrackingNumber());
            customTracking.setCustomTrackingProvider(trackingProvider);
            String link = TRACKING_PROVIDER_LINK_MAP.get(trackingProvider.toUpperCase());
            if (link != null) {
                customTracking.setCustomTrackingLink(link.replace("{trackingNumber}", tracking.getTrackingNumber()));
            }
            request = post(uri, getString(customTracking));
        }

        return getRequestWrapped(request, TrackingResponse.class);
    }
}