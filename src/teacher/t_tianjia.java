package teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import lianjie.lian;
/*
@课程表 课程号，教师工号，课程名，最多招收数，周几，节次，是否需要多媒体，教室号
create table course(
	No int primary key auto_increment,
	tNo int,
	cName varchar(24) not null,
	number int not null,
	week char(2) constraint w1 check(week in('一','二','三','四','五')),
	class int constraint w2 check(class between 1 and 5),
	whether char(2)	constraint w3 check(whether in('否','是')),
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
    
	public int save() {//课程号，教师工号，课程名，最多招收数，周几，节次，是否需要多媒体，教室号
		con=lian.getCon();	
		System.out.println("请输入课程号：");
		int No=reader.nextInt();
		System.out.println("请输入教师工号：");
		int tNo=reader.nextInt();
		System.out.println("请输入课程名：");
		String name=reader.next();
		System.out.println("请输入最多招收人数：");
		int number=reader.nextInt();
		System.out.println("请输入周次（一 ~~ 五）：");
		String week=reader.next();
		System.out.println("请输入节次（1~5）：");
		int clas=reader.nextInt();
		System.out.println("请输入是否需要多媒体（是，否）:");
		String whether=reader.next();
		System.out.println("请输入教室号：");
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
			System.out.println("添加成功！！！");
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
