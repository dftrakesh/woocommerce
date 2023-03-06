package io.github.dft.woocommerce.model.orderapi.ordernote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNoteWrapper extends ArrayList<OrderNote> {
}
