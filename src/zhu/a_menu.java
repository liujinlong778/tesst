package zhu;

import administer.*;
import java.util.*;

public class a_menu {
	a_classroom Aclass=new a_classroom();
	a_student Astu=new a_student();
	a_teacher Atea=new a_teacher();
	Scanner reader=new Scanner(System.in);
	int t=0;
	int a=0;
	public void caidan() {
		t=1;
		while(t==1) {
			System.out.println("1����ӽ���");
			System.out.println("2�����ѧ���˺�");
			System.out.println("3����ӽ�ʦ�˺�");
			System.out.println("4���˳�");
			System.out.println("������Ҫִ�еĲ�����ţ�");
			a=reader.nextInt();
			switch(a) {
				case 1:Aclass.addClass();break;
				case 2:Astu.addstu();break;
				case 3:Atea.addtea();break;
				case 4:t=2;break;
				default:System.out.println("��������ȷ�Ĳ�����ţ�");
			}
		}
	}
}
