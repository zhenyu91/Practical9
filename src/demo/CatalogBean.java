package demo;

/**
 * Created by 150436p on 12/12/2016.
 */
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.List;

@ManagedBean(name="catalogBean")
@RequestScoped
public class CatalogBean {
    private List<Book> books;

    @PostConstruct
    public void init() {
        BookDAO dao = new BookDAO();
        books = dao.getBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addToCart(Book b) {
        showMessage("Added book with id : " + b.getBookId());
        // logic to add book to cart below
    }

    public void showMessage(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}