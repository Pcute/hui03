package dao;

import domain.Book;

import java.util.List;

public interface BooktDAO {
	void save(Book b);
	void update(Book b);
	void delete(int name);
	Book get(int name);
	List<Book> getAll();
	public List<Book> getRecommadation(int size);
	public List<Book> getRecommthisweek(int size);

}
