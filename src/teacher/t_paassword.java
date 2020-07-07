package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;

public class t_paassword{
	int tNo;
	public t_paassword(int tNo){
		this.tNo=tNo;
	}
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstm = null;
	Connection con=null;
	int t=0;
	public int t_pass() {
		try {
			con=lian.getCon();
			String sql="select * from teacher where tNo=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, tNo);
			System.out.println("������ԭ���룺");
			String pass=reader.next();
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if((rs.getString(2)).equals(pass)) {
					System.out.println("�����������룺");
					pass=reader.next();
					sql="update teacher set tPassWord=? where tNo=?";
					pstm=con.prepareStatement(sql);
					pstm.setString(1, pass);
					pstm.setInt(2,tNo);
					pstm.executeUpdate();
					System.out.println("�޸ĳɹ�������");
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
