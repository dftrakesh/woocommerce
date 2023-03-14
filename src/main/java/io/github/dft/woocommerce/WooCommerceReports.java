package io.github.dft.woocommerce;

import io.github.dft.woocommerce.model.reportapi.ReportsWrapper;
import io.github.dft.woocommerce.model.reportapi.SalesReportWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalCouponWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalCustomerwrapper;
import io.github.dft.woocommerce.model.reportapi.TotalOrderWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalProductWrapper;
import io.github.dft.woocommerce.model.reportapi.TotalReviewWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Base64;
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

public class WooCommerceReports extends WooCommerceSdk{

    public WooCommerceReports() {
        super();
    }

    @SneakyThrows
    public ReportsWrapper getAllReports(String storeDomain, HashMap<String,String> params){
        URI uri = URI.create(storeDomain.concat(API_BASE_END_POINT.concat("/reports")));
        uri = addParameters(uri,params);
        System.out.println(uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,ReportsWrapper.class);
    }

    @SneakyThrows
    public SalesReportWrapper getSalesReport(HashMap<String, String> params) {
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+SALES_ENDPOINT));
        System.out.println("uri : "+uri);
        String originalInput = params.get("consumer_key").concat(":").concat(params.get("consumer_secret"));
        String headerString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        params.remove("consumer_key");
        params.remove("consumer_secret");
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .header("Authorization","Basic ".concat(headerString))
                .build();

        return getRequestWrapped(request, SalesReportWrapper.class);
    }

    public SalesReportWrapper getSellerReport(HashMap<String, String> params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+TOP_SELLER_ENDPOINT));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,SalesReportWrapper.class);

    }

    public TotalCouponWrapper getTotalCoupon(HashMap<String, String> params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+(COUPONS_ENDPOINT)));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,TotalCouponWrapper.class);
    }

    public TotalCustomerwrapper getTotalCustomer(HashMap<String, String>params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+CUSTOMERS_ENDPOINT));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,TotalCustomerwrapper.class);

    }

    public TotalOrderWrapper getTotalOrder(HashMap<String,String> params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+ORDERS_ENDPOINT));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,TotalOrderWrapper.class);
    }

    public TotalProductWrapper getTotalProduct(HashMap<String, String> params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+PRODUCTS_ENDPOINT));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,TotalProductWrapper.class);
    }

    public TotalReviewWrapper getTotalReview(HashMap<String,String> params){
        URI uri = URI.create(API_BASE_END_POINT
                .concat(REPORT_ENDPOINT.concat(SLASH_CHARACTER)+REVIEWS_ENDPOINT));
        System.out.println("uri : "+uri);
        uri = addParameters(uri,params);
        System.out.println("new uri : "+uri);
        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();
        return getRequestWrapped(request,TotalReviewWrapper.class);

    }

}
