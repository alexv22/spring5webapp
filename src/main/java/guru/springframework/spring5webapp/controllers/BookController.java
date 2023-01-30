package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {


    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) { //model object is going to get returned to the view

        model.addAttribute("books", bookRepository.findAll()); //at runtime when spring gets a request to the url /books, it is going to execute thr get books method
        //and it's going to provide that method a model object and we are saying: for that model we are going to
        //add the attribute called books and we're going to execute book repository which is going to give us a list of books
        return "books/list";
    }
}
