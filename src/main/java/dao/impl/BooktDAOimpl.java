package dao.impl;

import dao.BooktDAO;
import domain.Book;
import jdbc.jdbc.util.CRUDTmpl;
import jdbc.jdbc.util.IResultSetHandler;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BooktDAOimpl implements BooktDAO {
	@Override
	public void save(Book b) {
		String sql="insert into bookt value(?,?,?,?,?,?,?,?,?)";
		CRUDTmpl.executeUpdate(sql,b.getBookIsbn(),b.getBookName(),b.getBookAuthor(),b.getBookTypeId(),b.getPublishingId(),b.getPrice(),b.getBookPublishTime(),b.getBookNum(),b.getBookSaleNum());
	}

	@Override
	public void update(Book b) {
		int id=b.getBookId();
		String sql="update bookt set book_ISBN=?,book_Name=?,book_Author=? where book_ID=id";
		CRUDTmpl.executeUpdate(sql,b.getBookIsbn(),b.getBookName(),b.getBookAuthor());
	}

	@Override
	public void delete(int id) {
		String sql="delete from bookt where book_ID=?";
		CRUDTmpl.executeUpdate(sql,id);
	}

	@Override
	public Book get(int id) {
		String sql="select * from bookt where book_ID=?";
		IResultSetHandler <List<Book>>rs=new booktResultSetImp();
		List<Book>list= CRUDTmpl.executeQuery(sql,rs,id);
		return list.size()==1?list.get(0):null;
	}

	@Override
	public List<Book> getAll() {
		String sql="select * from bookt";
		IResultSetHandler<List<Book>>rs=new booktResultSetImp();
		List<Book>list=CRUDTmpl.executeQuery(sql,rs);
		return list;
	}

	@Override
	public List<Book> getRecommadation(int size) {
		String sql="select * from bookt limit 0,?";//select book_Name,book_Image from bookt limit 0,?
		IResultSetHandler<List<Book>>rs=new booktResultSetImp();
		List<Book> list=new ArrayList<>();
		list=CRUDTmpl.executeQuery(sql,rs,size);
		return list;
	}

	@Override
	public List<Book> getRecommthisweek(int size) {
		List<Book>list=new ArrayList<>();
		String sql="select * from bookt order by book_SaleNum desc limit 0,?";
		//select book_name, book_Image,book_Introduction from bookt order by book_SaleNum desc limit 0,?"
		IResultSetHandler<List<Book>>rs=new booktResultSetImp();
		list=CRUDTmpl.executeQuery(sql,rs,size);
		return list;
	}
}
class booktResultSetImp implements IResultSetHandler<List<Book>>{
	@Override
	public List<Book> handler(ResultSet rs) throws Exception {
		List<Book>list=new ArrayList<>();
		while (rs.next()){
			Book b=new Book();
			b.setBookId(rs.getInt(1));
			b.setBookIsbn(rs.getString(2));
			b.setBookName(rs.getString(3));
			b.setBookAuthor(rs.getString(4));
			b.setBookTypeId(rs.getInt(5));
			b.setPublishingId(rs.getInt(6));
			b.setPrice(rs.getInt(7));
			b.setBookPublishTime(rs.getDate(8));
			b.setBookNum(rs.getInt(9));
			b.setBookSaleNum(rs.getInt(10));
			b.setBookImage(rs.getString(11));
			b.setBookIntroduction(rs.getString(12));
			b.setBookInformation(rs.getString(13));
			list.add(b);
		}
		return list;
	}
}