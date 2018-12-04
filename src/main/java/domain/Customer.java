package domain;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Customer {
	int custId;
	String custNo;
	String custPwd;
	Date lastLogin;
	String email;
	String custImg;
	public String getCustImg() {
		return custImg;
	}

	public void setCustImg(String custImg) {
		this.custImg = custImg;
	}
	public int getSustId() {
		return custId;
	}

	public void setSustId(int sustId) {
		this.custId = sustId;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustPwd() {
		return custPwd;
	}

	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
