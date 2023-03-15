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

import static io.github.dft.woocommerce.constatndcode.ConstantCode.API_BASE_END_POINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.COUPONS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.CUSTOMERS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.ORDERS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.PRODUCTS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.REPORT_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.REVIEWS_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.SALES_ENDPOINT;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.SLASH_CHARACTER;
import static io.github.dft.woocommerce.constatndcode.ConstantCode.TOP_SELLER_ENDPOINT;

public class WooCommerceReports extends WooCommerceSdk {

    public WooCommerceReports(AccessCredential accessCredential) {
        super(accessCredential);
    }


    @SneakyThrows
    public ReportsWrapper getAllReports(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat("/reports")));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), ReportsWrapper.class);
    }


    @SneakyThrows
    public SalesReportWrapper getSalesReport(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + SALES_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), SalesReportWrapper.class);
    }

    @SneakyThrows
    public SalesReportWrapper getSellerReport(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + TOP_SELLER_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), SalesReportWrapper.class);
    }

    @SneakyThrows
    public TotalCouponWrapper getTotalCoupon(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + (COUPONS_ENDPOINT))));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), TotalCouponWrapper.class);

    }

    public TotalCustomerwrapper getTotalCustomer(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + CUSTOMERS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), TotalCustomerwrapper.class);

    }

    public TotalOrderWrapper getTotalOrder(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + ORDERS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), TotalOrderWrapper.class);
    }

    public TotalProductWrapper getTotalProduct(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + PRODUCTS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), TotalProductWrapper.class);
    }

    public TotalReviewWrapper getTotalReview(String storeDomain, HashMap<String, String> params) {
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER) + REVIEWS_ENDPOINT)));
        uri = addParameters(uri, params);
        return getRequestWrapped(getRequest(uri), TotalReviewWrapper.class);
    }
}