package fr.gpereira.bookstore.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import fr.gpereira.bookstore.entity.Book;
import fr.gpereira.bookstore.service.BookService;

/**
 * 
 * Book Managed Bean
 *
 */
@ManagedBean(name="bookMB")
@RequestScoped
public class BookManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	// TODO Constructor injection
	@ManagedProperty(value="#{BookService}")
	BookService bookService;
	
	List<Book> bookList;
	
	private String title;
	private String author;
	private Date releaseDate;
		
	/**
	 * Add Book
	 * 
	 * @return String - Response Message
	 */
	public String addBook() {
		try {
			Book book = new Book();
			book.setTitle(getTitle());
			book.setAuthor(getAuthor());
			book.setReleaseDate(getReleaseDate());
			getBookService().addBook(book);
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		
		return ERROR;
	}
	
	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setTitle("");
		this.setAuthor("");
		this.setReleaseDate(new Date());
	}
	
	/**
	 * Get Book List
	 * 
	 * @return List - Book List
	 */
	public List<Book> getBookList() {
		bookList = new ArrayList<Book>();
		bookList.addAll(getBookService().getBooks());
		return bookList;
	}
	
	/**
	 * Get Book Service
	 * 
	 * @return IBookService - Book Service
	 */
	public BookService getBookService() {
		return bookService;
	}

	/**
	 * Set Book Service
	 * 
	 * @param IBookService - Book Service
	 */
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	/**
	 * Set Book List
	 * 
	 * @param List - Book List
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	/**
	 * Get Book Title
	 * 
	 * @return String - Book Title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set Book Title
	 * 
	 * @param String - Book Title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get Book Author
	 * 
	 * @return String - Book Author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Set Book Author
	 * 
	 * @param String - Book Author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	/**
	 * Returns the release date
	 * @return
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	/**
	 * Sets the release date
	 * @param releaseDate
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}