package zhu;

import java.util.Scanner;

public class menu {
	Scanner reader=new Scanner(System.in);
	int a=0;//ѡ������
	int t=0;//��ʦ����
	int s=0;//ѧ����
	public void caidan() {
		while(a!=3) {
			System.out.println("1����ʦ��¼");
			System.out.println("2��ѧ����¼");
			System.out.println("3���˳�");
			System.out.println("��ѡ�� ��ʦ/ѧ�� ��¼��");
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
			if(a<1&&a>3)System.out.println("��������ȷ��ѡ�����");
		}
	}
}
