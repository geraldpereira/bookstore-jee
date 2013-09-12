package fr.gpereira.bookstore.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.gpereira.bookstore.dao.BookDAO;
import fr.gpereira.bookstore.entity.Book;

/**
 * 
 * Book Service
 * 
 */
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	private final BookDAO bookDAO;
	
	/**
	 * Constructor
	 * @param bookDAO
	 */
	public BookServiceImpl(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}

	/**
	 * Add Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	/**
	 * Delete Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);
	}
	
	/**
	 * Update Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}
	
	/**
	 * Get Book
	 * 
	 * @param  int Book Id
	 */
	@Override
	public Book getBookById(int id) {
		return bookDAO.getBookById(id);
	}

	/**
	 * Get Book List
	 * 
	 */
	@Override
	public List<Book> getBooks() {	
		return bookDAO.getBooks();
	}

}
