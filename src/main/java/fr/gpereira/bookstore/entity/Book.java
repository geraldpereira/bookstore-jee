package fr.gpereira.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.common.base.Objects;

/**
 * 
 * Book entity
 * 
 * @author gpereira
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Book.ALL, query = "SELECT b FROM Book b "),
		@NamedQuery(name = Book.TOTAL, query = "SELECT COUNT(b) FROM Book b") })
public class Book implements Serializable {

	public final static String ALL = "Book.populateBook";
	public final static String TOTAL = "Book.countBooksTotal";

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 45)
	private String title;

	@Column(length = 45)
	private String author;

	@Column
	private Date releaseDate;

	/**
	 * Get Id
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Book title
	 * 
	 * @return Book title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the book title
	 * 
	 * @param title
	 *            the book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The book author
	 * 
	 * @return the book author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the book author
	 * 
	 * @param author
	 *            book author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * The book release date
	 * 
	 * @return the book release date
	 */
	public Date getReleaseDate() {
		return (Date) releaseDate.clone();
	}

	/**
	 * 
	 * @param releaseDate
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = (Date) releaseDate.clone();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Book) {
			return this.hashCode() == obj.hashCode();
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("id", id).add("title", title)
				.add("author", author).add("release date", releaseDate)
				.toString();
	}
}