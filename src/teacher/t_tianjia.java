package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;
/*
@�γ̱� �γ̺ţ���ʦ���ţ��γ�����������������ܼ����ڴΣ��Ƿ���Ҫ��ý�壬���Һ�
create table course(
	No int primary key auto_increment,
	tNo int,
	cName varchar(24) not null,
	number int not null,
	week char(2) constraint w1 check(week in('һ','��','��','��','��')),
	class int constraint w2 check(class between 1 and 5),
	whether char(2)	constraint w3 check(whether in('��','��')),
	cNo int,
	foreign key(tNo) references teacher(tNo),
	foreign key(cNo) references classroom(cNo)
);
 * */

public class t_tianjia {
	Scanner reader=new Scanner(System.in);
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	Connection con=null;
    
	public int save() {//�γ̺ţ���ʦ���ţ��γ�����������������ܼ����ڴΣ��Ƿ���Ҫ��ý�壬���Һ�
		con=lian.getCon();	
		System.out.println("������γ̺ţ�");
		int No=reader.nextInt();
		System.out.println("�������ʦ���ţ�");
		int tNo=reader.nextInt();
		System.out.println("������γ�����");
		String name=reader.next();
		System.out.println("�������������������");
		int number=reader.nextInt();
		System.out.println("�������ܴΣ�һ ~~ �壩��");
		String week=reader.next();
		System.out.println("������ڴΣ�1~5����");
		int clas=reader.nextInt();
		System.out.println("�������Ƿ���Ҫ��ý�壨�ǣ���:");
		String whether=reader.next();
		System.out.println("��������Һţ�");
		int cNo=reader.nextInt();
		try {
			String sql="insert into course(No,tNo,cName,number,week,class,whether,cNo) values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,No);
			pstmt.setInt(2,tNo);
			pstmt.setString(3, name);
			pstmt.setInt(4,number);
			pstmt.setString(5, week);
			pstmt.setInt(6,clas);
			pstmt.setString(7, whether);
			pstmt.setInt(8,cNo);
			pstmt.executeUpdate();
			System.out.println("��ӳɹ�������");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			lian.close(con, pstmt, rs);
		}
		return 0;
	}
}
