package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.shipmenttrackingapi.Tracking;
import io.github.dft.woocommerce.model.shipmenttrackingapi.TrackingResponse;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpRequest;

public class WooCommerceShipmentTracking extends WooCommerceSdk {

    private String SHIPMENT_TRACKING_ENDPOINT = "orders/orderId/shipment-trackings";

    public WooCommerceShipmentTracking(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public TrackingResponse createShipmentTracking(String orderId, Tracking tracking) {
        URI uri = shipmentTrackingBaseUrl(SHIPMENT_TRACKING_ENDPOINT.replace("orderId", orderId));
        HttpRequest request = post(uri, getString(tracking));

        return getRequestWrapped(request, TrackingResponse.class);
    }
}