package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class s_chaxun {
	int sNo;
	public s_chaxun(int sNo){
		this.sNo=sNo;
	}
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	int t=0;
	public int s_cha() {
		try {
			con=lian.getCon();
			String sql="select * from is_sc where sNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"
									+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			lian.close(con, pstmt, rs);
		}
		return t;
	}
}
