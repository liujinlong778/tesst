package zhu;

import java.util.Scanner;

import teacher.*;
import administer.a_denglu;

public class t_menu {
	t_chakan Tcha;				//查询
	t_denglu Tdeng=new t_denglu();				//登录
	t_paassword Tpass;			//修改密码
	t_jieke Tjie;				//结课
	t_tianjia Ttian;			//添加课程
	kechenghao ke;				//查课程号
	
	a_menu a=new a_menu();		//管理员菜单
	a_denglu ad=new a_denglu();
	
	Scanner reader=new Scanner(System.in);
	int t=0;	//教师工号
	int c=0;	//课程号
	int s=0;
	int b=0;
	public int deng() {
		while(s==0) {
			t=Tdeng.denglu();
			if(t==0) {
				System.out.println("输入 0 重新登录或者输入其他数字结束运行：");
				s=reader.nextInt();
			}
			else s=1;
		}
		return t;
	}
	public void caidan() {
		ke=new kechenghao(t);
		s=1;
		while(s==1) {
			System.out.println("1、查看选修本门课的学生");
			System.out.println("2、添加课程");
			System.out.println("3、修改密码");
			System.out.println("4、结课");
			System.out.println("5、退出");
			System.out.println("6、管理员登录");
			System.out.println("请输入要执行的操作序号：");
			b=reader.nextInt();
			switch(b) {
				case 1:
					c=ke.coco();
					if(c==0)ke.co();
					else {
						Tcha=new t_chakan(c);
						Tcha.query();
					}
					break;
				case 2:
					c=ke.coco();
					if(c==0){
						Ttian=new t_tianjia();
						Ttian.save();
					}
					else System.out.println("已有课程，请先结课再添加课程！！！");
					break;
				case 3:Tpass=new t_paassword(t);Tpass.t_pass();break;
				case 4:Tjie=new t_jieke(c);Tjie.delete();break;
				case 5:s=2;break;
				case 6:
					if((ad.denglu())!=0)a.caidan();break;
				default:System.out.println("请输入正确的操作序号：");
			}
		}
	}
}
