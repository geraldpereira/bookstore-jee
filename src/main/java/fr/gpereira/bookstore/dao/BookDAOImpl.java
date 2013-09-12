package fr.gpereira.bookstore.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import fr.gpereira.bookstore.entity.Book;

public class BookDAOImpl implements BookDAO {
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBook(Book book) {
		getSessionFactory().getCurrentSession().save(book);
	}

	@Override
	public void deleteBook(Book book) {
		getSessionFactory().getCurrentSession().delete(book);
	}

	@Override
	public void updateBook(Book book) {
		getSessionFactory().getCurrentSession().update(book);
	}

	@Override
	public Book getBookById(int id) {
		List<Book> list = (List<Book>) getSessionFactory().getCurrentSession()
				.createQuery("from Book where id=?").setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public List<Book> getBooks() {
		List<Book> list = (List<Book>) getSessionFactory().getCurrentSession()
				.createQuery("from Book").list();
		return list;
	}
}
