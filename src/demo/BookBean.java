package demo;

/**
 * Created by 150436p on 12/12/2016.
 */
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="bookBean")
@ViewScoped
public class BookBean {
    Book book;
    @PostConstruct
    public void init() {
        BookDAO dao = new BookDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        String bookId = context.getExternalContext().getRequestParameterMap().get("bookId");
        if (bookId == null) {
            book = dao.getBook();
        } else {
            book = dao.getBook(Integer.parseInt(bookId));
        }
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}