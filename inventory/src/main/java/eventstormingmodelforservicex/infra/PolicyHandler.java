package eventstormingmodelforservicex.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import eventstormingmodelforservicex.config.kafka.KafkaProcessor;
import eventstormingmodelforservicex.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StockRepository stockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Shipped'"
    )
    public void wheneverShipped_UpdateStock(@Payload Shipped shipped) {
        Shipped event = shipped;
        System.out.println(
            "\n\n##### listener UpdateStock : " + shipped + "\n\n"
        );

        // Sample Logic //
        Stock.updateStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCancled'"
    )
    public void wheneverShippingCancled_UpdateStock(
        @Payload ShippingCancled shippingCancled
    ) {
        ShippingCancled event = shippingCancled;
        System.out.println(
            "\n\n##### listener UpdateStock : " + shippingCancled + "\n\n"
        );

        // Sample Logic //
        Stock.updateStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
