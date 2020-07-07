package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class s_password {
	int sNo;
	public s_password(int sNo){
		this.sNo=sNo;
	}
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstm = null;
	Connection con=null;
	int t=0;
	public int s_pass() {
		try {
			con=lian.getCon();
			String sql="select * from student where sNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, sNo);
			System.out.println("������ԭ���룺");
			String pass=reader.next();
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if((rs.getString(2)).equals(pass)) {
					System.out.println("�����������룺");
					pass=reader.next();
					sql="update student set sPassWord=? where sNo=?";
					pstm=con.prepareStatement(sql);
					pstm.setString(1, pass);
					pstm.setInt(2,sNo);
					pstm.executeUpdate();
					System.out.println("�޸�����ɹ�������");
				}
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
		return t;
	}
}
