package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;;

public class s_xuanke {
	public s_xuanke(int sNo){
		this.sNo=sNo;
	}
	int sNo;
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	public void xuan(){
		try {
			con=lian.getCon();
			String sql="select * from course";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//System.out.println("");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
			}
			System.out.println("输入0返回或者请输入要添加的课程号：");
			int No=reader.nextInt();
			if(No!=0) {
				sql="insert into choice(sNo,No) values(?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, sNo);
				pstmt.setInt(2, No);
				pstmt.executeUpdate();
				System.out.println("选课成功！！！");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			lian.close(con, pstmt, rs);
		}
		
	}
}
