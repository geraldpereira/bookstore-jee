package fr.gpereira.bookstore.dao;

import java.util.List;

import fr.gpereira.bookstore.entity.Book;


/**
 * 
 * Book DAO Interface
 *
 */
public interface BookDAO {
	/**
	 * Add Book
	 * 
	 * @param  Book book
	 */
	void addBook(Book book);
	
	/**
	 * Update Book
	 * 
	 * @param  Book book
	 */
	void updateBook(Book book);
	
	/**
	 * Delete Book
	 * 
	 * @param  Book book
	 */
	void deleteBook(Book book);
	
	/**
	 * Get Book
	 * 
	 * @param  int Book Id
	 */
	Book getBookById(int id);
	
	/**
	 * Get Book List
	 * 
	 */
	List<Book> getBooks();
}
