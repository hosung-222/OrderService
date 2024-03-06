package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.InventoryApplication;
import eventstormingmodelforservicex.domain.StockIncreased;
import eventstormingmodelforservicex.domain.StockReduced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Stock_table")
@Data
//<<< DDD / Aggregate Root
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer qty;

    private Long itemId;

    @PostPersist
    public void onPostPersist() {
        StockReduced stockReduced = new StockReduced(this);
        stockReduced.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static StockRepository repository() {
        StockRepository stockRepository = InventoryApplication.applicationContext.getBean(
            StockRepository.class
        );
        return stockRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStock(Shipped shipped) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(shipped.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStock(ShippingCancled shippingCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(shippingCancled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
