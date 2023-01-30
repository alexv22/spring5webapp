package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Publisher;

import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher pgn = new Publisher();
        pgn.setName("SFG Publishing");
        pgn.setCity("Timisoara");
        pgn.setState("Timis");
        pgn.setZip("307200");
        publisherRepository.save(pgn);

        System.out.println("Started in Bootstrap");

        System.out.println("Number of publishers: " + publisherRepository.count());


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain in Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pgn);
        pgn.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pgn);

        Author rod = new Author("Rod", "Johhnson");
        Book noEJB = new Book("J2EE Development without EJB", "987654321");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(pgn);
        pgn.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pgn);

        System.out.println("Number of  Books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + pgn.getBooks().size());


    }
}
