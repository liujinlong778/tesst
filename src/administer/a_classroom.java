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
		System.out.println("���������λ��");
		String adress=reader.next();
		try {
			String sql="insert into classroom(adress) values(?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adress);
			pstmt.executeUpdate();
			System.out.println("��ӽ��ҳɹ�������");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lian.close(con, pstmt, rs);
		}
	}
}
