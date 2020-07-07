package zhu;

import student.*;
import java.util.*;

public class s_menu {
	s_chaxun Scha;				//查询
	s_denglu Sdeng=new s_denglu();//登录
	s_password Spass;			//修改密码
	s_xuanke Sxuan;				//选课
	Scanner reader=new Scanner(System.in);
	int s=0;	//学生号
	int t=0;
	int a=0;
	public int deng() {
		while(t==0) {
			s=Sdeng.denglu();
			if(s==0) {
				System.out.println("输入 0 重新登录或者输入其他数字结束运行：");
				t=reader.nextInt();
			}
			else t=1;
		}
		return s;
	}
	public void caidan() {
		t=1;
		while(t==1) {
			System.out.println("1、查询已选课程");
			System.out.println("2、选课");
			System.out.println("3、修改密码");
			System.out.println("4、退出");
			System.out.println("请输入要执行的操作序号：");
			a=reader.nextInt();
			switch(a) {
				case 1:Scha=new s_chaxun(s);Scha.s_cha();break;
				case 2:Sxuan=new s_xuanke(s);Sxuan.xuan();break;
				case 3:Spass=new s_password(s);Spass.s_pass();break;
				case 4:t=2;break;
				default:System.out.println("请输入正确的操作序号：");
			}
		}
	}
	
}
