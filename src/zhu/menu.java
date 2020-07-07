package zhu;

import java.util.Scanner;

public class menu {
	Scanner reader=new Scanner(System.in);
	int a=0;//选择的序号
	int t=0;//教师工号
	int s=0;//学生号
	public void caidan() {
		while(a!=3) {
			System.out.println("1、教师登录");
			System.out.println("2、学生登录");
			System.out.println("3、退出");
			System.out.println("请选择 教师/学生 登录：");
			a=reader.nextInt();
			switch(a) {
				case 1:
					t_menu t=new t_menu();
					if(t.deng()!=0)t.caidan();
					break;
				case 2:
					s_menu s=new s_menu();
					if(s.deng()!=0)s.caidan();
					break;
				case 3:a=3;break;
			}
			if(a<1&&a>3)System.out.println("请输入正确的选项！！！");
		}
	}
}
