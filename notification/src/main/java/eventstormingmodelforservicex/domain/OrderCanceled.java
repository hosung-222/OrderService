package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.domain.*;
import eventstormingmodelforservicex.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String address;
    private Long itemId;
    private Integer qty;
    private String status;
    private Long customerId;
}
