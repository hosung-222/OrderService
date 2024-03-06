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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StockIncreased'"
    )
    public void wheneverStockIncreased_대기고객에게알림메일을발송(
        @Payload StockIncreased stockIncreased
    ) {
        StockIncreased event = stockIncreased;
        System.out.println(
            "\n\n##### listener 대기고객에게알림메일을발송 : " +
            stockIncreased +
            "\n\n"
        );

        // Sample Logic //
        Order.대기고객에게알림메일을발송(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Shipped'"
    )
    public void wheneverShipped_주문상태갱신(@Payload Shipped shipped) {
        Shipped event = shipped;
        System.out.println(
            "\n\n##### listener 주문상태갱신 : " + shipped + "\n\n"
        );

        // Sample Logic //
        Order.주문상태갱신(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCancled'"
    )
    public void wheneverShippingCancled_주문상태갱신(
        @Payload ShippingCancled shippingCancled
    ) {
        ShippingCancled event = shippingCancled;
        System.out.println(
            "\n\n##### listener 주문상태갱신 : " + shippingCancled + "\n\n"
        );

        // Sample Logic //
        Order.주문상태갱신(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
