package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.domain.*;
import eventstormingmodelforservicex.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ShippingCancled extends AbstractEvent {

    private Long id;
    private String address;
    private Integer qty;
    private Long itemId;
    private Long orderId;
    private String status;

    public ShippingCancled(Shipping aggregate) {
        super(aggregate);
    }

    public ShippingCancled() {
        super();
    }
}
//>>> DDD / Domain Event
