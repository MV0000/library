package orders.bootstrap;

import orders.domain.Author;
import orders.domain.Book;
import orders.domain.Publisher;
import orders.repositories.AuthorRepository;
import orders.repositories.BookRepository;
import orders.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Boostrap");

        Publisher publisher = new Publisher();
        publisher.setName("Mystic Publishing");
        publisher.setCity("Gravity Falls");
        publisher.setState("GF");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven Design" ,"123321");

        eric.getBookSet().add(book);
        book.getAuthors().add(eric);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without JEE" ,"321123");

        rod.getBookSet().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count() );
        System.out.println("Started in Bootstrap" + publisher.getBooks().size());


    }
}
