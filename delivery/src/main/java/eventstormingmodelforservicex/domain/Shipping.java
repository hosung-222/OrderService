package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.DeliveryApplication;
import eventstormingmodelforservicex.domain.Shipped;
import eventstormingmodelforservicex.domain.ShippingCancled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Shipping_table")
@Data
//<<< DDD / Aggregate Root
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    private Integer qty;

    private Long itemId;

    private Long orderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Shipped shipped = new Shipped(this);
        shipped.publishAfterCommit();

        ShippingCancled shippingCancled = new ShippingCancled(this);
        shippingCancled.publishAfterCommit();
    }

    public static ShippingRepository repository() {
        ShippingRepository shippingRepository = DeliveryApplication.applicationContext.getBean(
            ShippingRepository.class
        );
        return shippingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void ship(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        Shipping shipping = new Shipping();
        repository().save(shipping);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(shipping->{
            
            shipping // do something
            repository().save(shipping);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancel(OrderCanceled orderCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Shipping shipping = new Shipping();
        repository().save(shipping);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(shipping->{
            
            shipping // do something
            repository().save(shipping);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
