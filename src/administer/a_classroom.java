package administer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class a_classroom {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	public void addClass(){
		con=lian.getCon();
		System.out.println("请输入教室位置");
		String adress=reader.next();
		try {
			String sql="insert into classroom(adress) values(?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adress);
			pstmt.executeUpdate();
			System.out.println("添加教室成功！！！");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lian.close(con, pstmt, rs);
		}
	}
}
