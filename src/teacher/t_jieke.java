package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class t_jieke {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	int No=0;
	public t_jieke(int a){
		No=a;
	}
	public void delete() {
		try {
			con=lian.getCon();
			if(No!=0) {
				String sql="delete from course where No=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,No);
				pstmt.executeUpdate();
			}
			else System.out.println("未开设课程！！！");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			System.out.println("结课成功!");
			lian.close(con, pstmt, rs);
		}
		
	}
}
