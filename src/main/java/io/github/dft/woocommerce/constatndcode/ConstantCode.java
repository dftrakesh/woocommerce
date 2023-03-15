package io.github.dft.woocommerce.constatndcode;

public interface ConstantCode {
    String API_BASE_END_POINT = "/wp-json/wc/v3";
    String ORDER_ENDPOINT = "/orders";
    String REFUND_ENDPOINT = "/refunds";
    String SLASH_CHARACTER = "/";
    String STORE_INFORMATION_ENDPOINT = "/system_status";
    String CUSTOMER_ENDPOINT = "/customers";
    String ORDER_NOTE_ENDPOINT = "/notes";
    String WEBHOOK_ENDPOINT = "/webhooks";
    String REPORT_ENDPOINT = "/reports";
    String SALES_ENDPOINT = "sales";
    String TOP_SELLER_ENDPOINT = "top_sellers";
    String COUPONS_ENDPOINT = "coupons/totals";
    String CUSTOMERS_ENDPOINT = "customers/totals";
    String ORDERS_ENDPOINT = "orders/totals";
    String PRODUCTS_ENDPOINT = "products/totals";
    String REVIEWS_ENDPOINT = "reviews/totals";
    String PRODUCT_ENDPOINT = "/products";
    String TERMS_ENDPOINT = "/terms";
    String PRODUCT_VARIATION_ENDPOINT = "/variations";
    String CATEGORY_ENDPOINT = "/products/categories";
    String ATTRIBUTE_ENDPOINT = "/products/attributes";
    String SHIPPING_ENDPOINT = "/products/shipping_classes";
    String TAG_ENDPOINT = "/products/tags";
    String REVIEW_ENDPOINT = "/products/reviews";
    String CONTENT_TYPE_VALUE = "application/json";

    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}
