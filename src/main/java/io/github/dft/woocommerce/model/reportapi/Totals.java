package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Totals {
    @JsonProperty("2021-05-03")
    private SalesReportTotals salesReportTotals1;
    @JsonProperty("2021-05-04")
    private SalesReportTotals salesReportTotals2;
}
