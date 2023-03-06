package io.github.dft.woocommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dft.woocommerce.model.customerapi.Customer;
import io.github.dft.woocommerce.model.customerapi.CustomerWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.woocommerce.constatndcode.ConstantCode.*;

public class WooCommerceCustomers extends WooCommerceSdk{
    public WooCommerceCustomers() {
        super();
    }

    @SneakyThrows
    public CustomerWrapper getAllCustomers(String storeDomain,HashMap<String, String> params){
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(CUSTOMER_ENDPOINT))));

        addParameters(uriBuilder,params);
        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request,CustomerWrapper.class);
    }

    @SneakyThrows
    public Customer getCustomerById(String storeDomain,HashMap<String, String> params,Integer id){
        URIBuilder uriBuilder = new URIBuilder(HTTPS.concat(storeDomain.concat(API_BASE_END_POINT
                .concat(CUSTOMER_ENDPOINT.concat(SLASH_CHARACTER) + id))));

        addParameters(uriBuilder,params);
        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .build();

        return getRequestWrapped(request,Customer.class);
    }
}
