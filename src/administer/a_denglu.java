package administer;

import java.util.Scanner;

public class a_denglu {
	Scanner re=new Scanner(System.in);
	public int denglu() {
		System.out.println("ÃÜÂë 1234");
		int t=0;
		System.out.println("ÇëÊäÈëÃÜÂë£º");
		int password=re.nextInt();
		if(password==1234)t=1;
		else System.out.println("ÃÜÂë´íÎó£¡£¡£¡");
		return t;
	}
}
