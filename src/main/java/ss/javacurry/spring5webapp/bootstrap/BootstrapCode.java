package ss.javacurry.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ss.javacurry.spring5webapp.model.Author;
import ss.javacurry.spring5webapp.model.Book;
import ss.javacurry.spring5webapp.model.Publisher;
import ss.javacurry.spring5webapp.repositories.AuthorRepository;
import ss.javacurry.spring5webapp.repositories.BookRepository;
import ss.javacurry.spring5webapp.repositories.PublisherRepository;


@Component
public class BootstrapCode implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapCode(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub1=new Publisher("Shashank", "1","2","3","4");

        publisherRepository.save(pub1);

        System.out.println("Publisher Count " +publisherRepository.count());

        Author auth1=new Author("Shashank","Saurabh");
        Book book1=new Book("New Java Curry","123456");
        auth1.getBooks().add(book1);

        book1.getAuthors().add(auth1);
        book1.setPublisher(pub1);
        pub1.getBook().add(book1);

        authorRepository.save(auth1);
        bookRepository.save(book1);

        System.out.println("Count "+ bookRepository.count());

        Author auth2=new Author("Shashank2","Saurabh2");
        Book book2=new Book("New Java Curry Edition 2","123456222");
        auth2.getBooks().add(book2);

        book2.getAuthors().add(auth2);
        book2.setPublisher(pub1);

        pub1.getBook().add(book2);

        Book book3=new Book("New Java Curry Edition 2","123456222");
        book3.getAuthors().add(auth2);
        book3.setPublisher(pub1);

        authorRepository.save(auth2);
        bookRepository.save(book2);
        bookRepository.save(book3);

         publisherRepository.save(pub1);  

        System.out.println("Count "+ bookRepository.count());
        System.out.println("Count "+ pub1.getBook().size());



    }
}
