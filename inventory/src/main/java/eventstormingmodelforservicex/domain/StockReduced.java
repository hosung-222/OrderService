package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.domain.*;
import eventstormingmodelforservicex.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class StockReduced extends AbstractEvent {

    private Long id;

    public StockReduced(Stock aggregate) {
        super(aggregate);
    }

    public StockReduced() {
        super();
    }
}
//>>> DDD / Domain Event
