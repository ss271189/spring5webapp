package ss.javacurry.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ss.javacurry.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
