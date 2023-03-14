package io.github.dft.woocommerce.model.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportsWrapper extends ArrayList<Reports> {
}
