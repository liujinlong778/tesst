package administer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class a_teacher {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
	public void addtea(){
		con=lian.getCon();
		System.out.println("�����빤�ţ�");
		int tNo=reader.nextInt();
		System.out.println("���������룺");
		String password=reader.next();
		System.out.println("������������");
		String tName=reader.next();
		System.out.println("������绰���룺");
		String tell=reader.next();
		try {
			String sql="insert into teacher(tNo,tPassWord,tName,tell) values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			pstmt.setString(2,password);
			pstmt.setString(3, tName);
			pstmt.setString(4, tell);
			pstmt.executeUpdate();
			System.out.println("��ӽ�ʦ�˺ųɹ�������");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lian.close(con, pstmt, rs);
		}
	}
}
