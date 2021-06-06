package ss.javacurry.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import ss.javacurry.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
