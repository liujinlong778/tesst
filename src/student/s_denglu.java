package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class s_denglu {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	int t=0;
	public int denglu() {
		try {
			con=lian.getCon();
			String sql="select * from student where sNo=?";
			System.out.println("请输学号：");
			int sNo=reader.nextInt();
			System.out.println("请输入密码");
			String password=reader.next();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if((rs.getString(2)).equals(password))t=sNo;//密码正确则返回学号，其他返回0
				else System.out.println("密码错误！！！");
			}
			else System.out.println("账号错误！！");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			lian.close(con, pstmt, rs);
		}
		if(t!=0)System.out.println("登录成功！！！");
		return t;
	}
}