package fr.gpereira.bookstore.service;

import java.util.List;

import fr.gpereira.bookstore.entity.Book;

/**
 * 
 * Book Service Interface
 *
 */
public interface BookService {
	
	/**
	 * Add Book
	 * 
	 * @param  Book user
	 */
	void addBook(Book user);
	
	/**
	 * Update Book
	 * 
	 * @param  Book user
	 */
	void updateBook(Book user);

	/**
	 * Delete Book
	 * 
	 * @param  Book user
	 */
	void deleteBook(Book user);
	
	/**
	 * Get Book
	 * 
	 * @param  int Book Id
	 */
	Book getBookById(int id);
	
	/**
	 * Get Book List
	 * 
	 * @return List - Book list
	 */
	List<Book> getBooks();
}
