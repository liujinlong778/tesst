package zhu;

import java.util.Scanner;

import teacher.*;
import administer.a_denglu;

public class t_menu {
	t_chakan Tcha;				//��ѯ
	t_denglu Tdeng=new t_denglu();				//��¼
	t_paassword Tpass;			//�޸�����
	t_jieke Tjie;				//���
	t_tianjia Ttian;			//��ӿγ�
	kechenghao ke;				//��γ̺�
	
	a_menu a=new a_menu();		//����Ա�˵�
	a_denglu ad=new a_denglu();
	
	Scanner reader=new Scanner(System.in);
	int t=0;	//��ʦ����
	int c=0;	//�γ̺�
	int s=0;
	int b=0;
	public int deng() {
		while(s==0) {
			t=Tdeng.denglu();
			if(t==0) {
				System.out.println("���� 0 ���µ�¼���������������ֽ������У�");
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
			System.out.println("1���鿴ѡ�ޱ��ſε�ѧ��");
			System.out.println("2����ӿγ�");
			System.out.println("3���޸�����");
			System.out.println("4�����");
			System.out.println("5���˳�");
			System.out.println("6������Ա��¼");
			System.out.println("������Ҫִ�еĲ�����ţ�");
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
					else System.out.println("���пγ̣����Ƚ������ӿγ̣�����");
					break;
				case 3:Tpass=new t_paassword(t);Tpass.t_pass();break;
				case 4:Tjie=new t_jieke(c);Tjie.delete();break;
				case 5:s=2;break;
				case 6:
					if((ad.denglu())!=0)a.caidan();break;
				default:System.out.println("��������ȷ�Ĳ�����ţ�");
			}
		}
	}
}
