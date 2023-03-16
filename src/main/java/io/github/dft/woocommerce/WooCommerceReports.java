package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.reportapi.*;
import lombok.SneakyThrows;
import java.net.URI;
import java.util.HashMap;

public class WooCommerceReports extends WooCommerceSdk {

    String API_BASE_END_POINT = "/wp-json/wc/v3";
    String FORWARD_SLASH_CHARACTER = "/";
    String REPORT_ENDPOINT = "/reports";
    String SALES_ENDPOINT = "sales";
    String TOP_SELLER_ENDPOINT = "top_sellers";
    String COUPONS_ENDPOINT = "coupons/totals";
    String CUSTOMERS_ENDPOINT = "customers/totals";
    String ORDERS_ENDPOINT = "orders/totals";
    String PRODUCTS_ENDPOINT = "products/totals";
    String REVIEWS_ENDPOINT = "reviews/totals";

    public WooCommerceReports(AccessCredential accessCredential) {
        super(accessCredential);
    }


    @SneakyThrows
    public ReportsWrapper getAllReports(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat("/reports")));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), ReportsWrapper.class);
    }


    @SneakyThrows
    public SalesReportWrapper getSalesReport(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + SALES_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), SalesReportWrapper.class);
    }

    @SneakyThrows
    public SalesReportWrapper getSellerReport(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + TOP_SELLER_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), SalesReportWrapper.class);
    }

    @SneakyThrows
    public TotalCouponWrapper getTotalCoupon(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + (COUPONS_ENDPOINT))));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), TotalCouponWrapper.class);

    }

    public TotalCustomerwrapper getTotalCustomer(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + CUSTOMERS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), TotalCustomerwrapper.class);

    }

    public TotalOrderWrapper getTotalOrder(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + ORDERS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), TotalOrderWrapper.class);
    }

    public TotalProductWrapper getTotalProduct(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + PRODUCTS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), TotalProductWrapper.class);
    }

    public TotalReviewWrapper getTotalReview(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(FORWARD_SLASH_CHARACTER) + REVIEWS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(get(uri), TotalReviewWrapper.class);
    }
}