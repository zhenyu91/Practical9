package demo;

/**
 * Created by 150436p on 12/12/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDAO {

    List<Book> bookList = null;
    private Random random = new Random();

    public BookDAO() {
        if (bookList == null) {
            addDummyBook();
        }
    }
    // methods to create 10 dummy book for book store
    private void addDummyBook() {
        bookList = new ArrayList<Book>();
        for (int i=0; i<10; i++) {
            Book b = new Book();
            b.setBookId(i);
            b.setTitle("Web Component edition " + i);
            b.setDescription("What an awesome book, I will read it over and over again!");
            b.setAuthor("Duke " + i);
            b.setPrice(i + 0.5f);
            b.setYear(2000+i);
            b.setInventory(i);
            bookList.add(b);
        }
    }
    // get all the books
    public List<Book> getBooks() {
        return bookList;
    }
    // get any random book
    public Book getBook() {
        return bookList.get(random.nextInt(bookList.size()));
    }
    // get a book with a given book id
    public Book getBook(int id) {
        return bookList.get(id);
    }
}