package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.authenticationapi.AccessCredential;
import io.github.dft.woocommerce.model.reportapi.ReportsWrapper;
import io.github.dft.woocommerce.model.reportapi.SalesReportWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalCouponWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalCustomerwrapper;
import io.github.dft.woocommerce.model.reportapi.TotalOrderWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalProductWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalReviewWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.HttpConstants.API_BASE_END_POINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.COUPONS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.CUSTOMERS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.ORDERS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.PRODUCTS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.REPORT_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.REVIEWS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.SALES_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.FORWARD_SLASH_CHARACTER;
import static io.github.dft.woocommerce.constatndcode.HttpConstants.TOP_SELLER_ENDPOINT;

public class WooCommerceReports extends WooCommerceSdk {

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