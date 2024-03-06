package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.domain.*;
import eventstormingmodelforservicex.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ShippingCancled extends AbstractEvent {

    private Long id;
    private String address;
    private Integer qty;
    private Long itemId;
    private Long orderId;
    private String status;
}
