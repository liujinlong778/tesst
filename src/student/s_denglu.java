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
			System.out.println("����ѧ�ţ�");
			int sNo=reader.nextInt();
			System.out.println("����������");
			String password=reader.next();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if((rs.getString(2)).equals(password))t=sNo;//������ȷ�򷵻�ѧ�ţ���������0
				else System.out.println("������󣡣���");
			}
			else System.out.println("�˺Ŵ��󣡣�");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			lian.close(con, pstmt, rs);
		}
		if(t!=0)System.out.println("��¼�ɹ�������");
		return t;
	}
}