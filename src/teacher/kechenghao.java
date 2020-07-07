package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class kechenghao {
	Scanner reader=new Scanner(System.in);
	int tNo;
	public kechenghao(int s) {
		tNo=s;
	}
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	int t=0;
	
	public int coco() {//得到课程号
		int No=0;
		try {
			con=lian.getCon();
			String sql="select * from course where tNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			rs=pstmt.executeQuery();
			if(rs.next())No=rs.getInt(1);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			lian.close(con, pstmt, rs);
		}
		return No;
	}
	public void co() {
		System.out.println("请先添加课程号！！！");
	}
}
