package zhu;

import student.*;
import java.util.*;

public class s_menu {
	s_chaxun Scha;				//��ѯ
	s_denglu Sdeng=new s_denglu();//��¼
	s_password Spass;			//�޸�����
	s_xuanke Sxuan;				//ѡ��
	Scanner reader=new Scanner(System.in);
	int s=0;	//ѧ����
	int t=0;
	int a=0;
	public int deng() {
		while(t==0) {
			s=Sdeng.denglu();
			if(s==0) {
				System.out.println("���� 0 ���µ�¼���������������ֽ������У�");
				t=reader.nextInt();
			}
			else t=1;
		}
		return s;
	}
	public void caidan() {
		t=1;
		while(t==1) {
			System.out.println("1����ѯ��ѡ�γ�");
			System.out.println("2��ѡ��");
			System.out.println("3���޸�����");
			System.out.println("4���˳�");
			System.out.println("������Ҫִ�еĲ�����ţ�");
			a=reader.nextInt();
			switch(a) {
				case 1:Scha=new s_chaxun(s);Scha.s_cha();break;
				case 2:Sxuan=new s_xuanke(s);Sxuan.xuan();break;
				case 3:Spass=new s_password(s);Spass.s_pass();break;
				case 4:t=2;break;
				default:System.out.println("��������ȷ�Ĳ�����ţ�");
			}
		}
	}
	
}
