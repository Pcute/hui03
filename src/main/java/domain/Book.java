package domain;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Book {
	int bookId;
	String bookIsbn;
	String bookName;
	String bookAuthor;
	int bookTypeId;
	int publishingId;
	int price;
	Date bookPublishTime;
	int bookNum;
	int bookSaleNum;
	String bookImage;
	String bookIntroduction;
	String bookInformation;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public int getPublishingId() {
		return publishingId;
	}

	public void setPublishingId(int publishingId) {
		this.publishingId = publishingId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getBookPublishTime() {
		return bookPublishTime;
	}

	public void setBookPublishTime(Date bookPublishTime) {
		this.bookPublishTime = bookPublishTime;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public int getBookSaleNum() {
		return bookSaleNum;
	}

	public void setBookSaleNum(int bookSaleNum) {
		this.bookSaleNum = bookSaleNum;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookIntroduction() {
		return bookIntroduction;
	}

	public void setBookIntroduction(String bookIntroduction) {
		this.bookIntroduction = bookIntroduction;
	}

	public String getBookInformation() {
		return bookInformation;
	}

	public void setBookInformation(String bookInformation) {
		this.bookInformation = bookInformation;
	}
}