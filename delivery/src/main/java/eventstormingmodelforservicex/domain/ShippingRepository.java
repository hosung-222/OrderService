package eventstormingmodelforservicex.domain;

import eventstormingmodelforservicex.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "shippings", path = "shippings")
public interface ShippingRepository
    extends PagingAndSortingRepository<Shipping, Long> {}
