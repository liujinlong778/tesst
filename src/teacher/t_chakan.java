package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class t_chakan {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	int No=0;
	public t_chakan(int a) {
		No=a;
	}
	public void query() {
		try {
			con=lian.getCon();
			String sql="select * from is_cc where No=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, No);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
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
