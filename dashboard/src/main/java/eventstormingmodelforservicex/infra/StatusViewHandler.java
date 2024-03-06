package eventstormingmodelforservicex.infra;

import eventstormingmodelforservicex.config.kafka.KafkaProcessor;
import eventstormingmodelforservicex.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class StatusViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private StatusRepository statusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            Status status = new Status();
            // view 객체에 이벤트의 Value 를 set 함
            status.setStatus("주문됨");
            status.setId(ordered.getId());
            // view 레파지 토리에 save
            statusRepository.save(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenShipped_then_UPDATE_1(@Payload Shipped shipped) {
        try {
            if (!shipped.validate()) return;
            // view 객체 조회
            Optional<Status> statusOptional = statusRepository.findById(
                shipped.getOrderId()
            );

            if (statusOptional.isPresent()) {
                Status status = statusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus("배송됨");
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenShippingCancled_then_UPDATE_2(
        @Payload ShippingCancled shippingCancled
    ) {
        try {
            if (!shippingCancled.validate()) return;
            // view 객체 조회
            Optional<Status> statusOptional = statusRepository.findById(
                shippingCancled.getOrderId()
            );

            if (statusOptional.isPresent()) {
                Status status = statusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus("수거됨");
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회
            Optional<Status> statusOptional = statusRepository.findById(
                orderCanceled.getId()
            );

            if (statusOptional.isPresent()) {
                Status status = statusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                status.setStatus("주문취소됨");
                // view 레파지 토리에 save
                statusRepository.save(status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
