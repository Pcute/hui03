package dao.impl;

import dao.BooktDAO;
import domain.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BooktDAOimplTest {

	@Test
	public void getRecommadation() {
		BooktDAO dao=new BooktDAOimpl();
		List<Book> booktList=null;
		booktList=dao.getRecommadation(4);
		assertNotNull(booktList);
		//assertEquals(booktList.size(),4);
	}

	@Test
	public void getRecommthisweek() {
		BooktDAO dao=new BooktDAOimpl();
		List<Book> booksThisWeek=null;
		booksThisWeek=dao.getRecommthisweek(1);
		assertEquals(booksThisWeek.size(),1);
		Book bookThisWeek=null;
		bookThisWeek=booksThisWeek.get(0);
		assertNotNull(booksThisWeek);
	}
	@Test
	public void getAll(){
		BooktDAO dao =new BooktDAOimpl();
		List<Book> book=null;
		book=dao.getAll();
		assertNotNull(book);
	}
}