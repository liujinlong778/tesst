package administer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class a_student {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	public void addstu(){
		con=lian.getCon();
		System.out.println("请输入学号：");
		int sNo=reader.nextInt();
		System.out.println("请输入密码：");
		String password=reader.next();
		System.out.println("请输入姓名：");
		String sName=reader.next();
		try {
			String sql="insert into student(sNo,sPassWord,sName) values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			pstmt.setString(2,password);
			pstmt.setString(3, sName);
			pstmt.executeUpdate();
			System.out.println("添加学生账号成功！！！");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lian.close(con, pstmt, rs);
		}
	}
}
