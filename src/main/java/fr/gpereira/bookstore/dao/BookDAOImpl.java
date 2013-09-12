package fr.gpereira.bookstore.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.gpereira.bookstore.entity.Book;

public class BookDAOImpl implements BookDAO {
	private final SessionFactory sessionFactory;

	/**
	 * Constructor
	 * @param sessionFactory
	 */
	public BookDAOImpl(final SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public Book getBookById(int id) {
		List<Book> list = (List<Book>) sessionFactory.getCurrentSession()
				.createQuery("from Book where id=?").setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public List<Book> getBooks() {
		List<Book> list = (List<Book>) sessionFactory.getCurrentSession()
				.createQuery("from Book").list();
		return list;
	}
}
