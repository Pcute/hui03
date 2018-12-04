package jdbc.jdbc.util;

import java.sql.*;

public class JDBCUtil {
	public static String driverManager="com.mysql.jdbc.Driver";
	static {
		//1.加载驱动
		try{
		Class.forName(driverManager);
		}catch(ClassNotFoundException e){
		e.printStackTrace();
		}
	}
	public static Connection getconn() throws Exception {
		String url="jdbc:mysql://localhost:3306/shoppingbook";
		String user="root";
		String pwd="1234";

		Connection conn=null;

		//Class.forName("JDBCUtil.driverManager");
		try {
			conn= DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if (rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			if (ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if (conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}
}
