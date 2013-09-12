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

	// BookDAO is injected ... Spring style
	// TODO There should be a way to do it guice style (using this object constructor) -> annotations ?
	BookDAO bookDAO;
	
	/**
	 * Add Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void addBook(Book book) {
		getBookDAO().addBook(book);
	}

	/**
	 * Delete Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void deleteBook(Book book) {
		getBookDAO().deleteBook(book);
	}
	
	/**
	 * Update Book
	 * 
	 * @param  Book book
	 */
	@Transactional(readOnly = false)
	@Override
	public void updateBook(Book book) {
		getBookDAO().updateBook(book);
	}
	
	/**
	 * Get Book
	 * 
	 * @param  int Book Id
	 */
	@Override
	public Book getBookById(int id) {
		return getBookDAO().getBookById(id);
	}

	/**
	 * Get Book List
	 * 
	 */
	@Override
	public List<Book> getBooks() {	
		return getBookDAO().getBooks();
	}

	/**
	 * Get Book DAO
	 * 
	 * @return IBookDAO - Book DAO
	 */
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	/**
	 * Set Book DAO
	 * 
	 * @param IBookDAO - Book DAO
	 */
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
