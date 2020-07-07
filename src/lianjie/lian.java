package lianjie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class lian {
	
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/paike?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	private static String userName="root";
	private static String password="root";
	
	
	/**
	 * 连接数据库
	 */
	static {
		try {
			// 执行驱动
			Class.forName(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接对象Con
	 * @return
	 */
	public static Connection getCon() {
		try {
			// 加载连接
			return DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭资源
	 */
	public static void close(Connection con,Statement st,ResultSet rs) {
		
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(st!=null) {
			try {
				st.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}