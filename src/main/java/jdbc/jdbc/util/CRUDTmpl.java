package jdbc.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDTmpl {
	public static int executeUpdate(String sql,Object...params) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.加载驱动
			//2.连接数据
			conn = JDBCUtil.getconn();
			//3.创建sql
			ps = conn.prepareStatement(sql);
			//设置参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//4.执行sql
			return ps.executeUpdate();
		} catch (Exception e) {

		} finally {
			//5.释放资源
			JDBCUtil.close(conn, ps, null);
		}
		return 0;
	}
	public static  <T>T executeQuery(String sql,IResultSetHandler<T>rh,Object...params){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			//1.加载驱动
			//2.链接数据
			conn=JDBCUtil.getconn();
			//3.创建sql
			ps=conn.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}//4.执行sql
			rs=ps.executeQuery();
			return rh.handler(rs);
		}	catch (Exception e){
			e.printStackTrace();
		}finally {
			//5.释放资源
			JDBCUtil.close(conn,ps,rs);
		}
		return null;
	}
}
