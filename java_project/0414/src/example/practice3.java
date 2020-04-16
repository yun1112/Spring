package example;

import java.util.Scanner;

public class practice3 {

	public static void main(String[] args) {
		int H,M,total=0;
		Scanner sc=new Scanner(System.in);
		H=sc.nextInt();
		M=sc.nextInt();
		
		if(H==0)
			H+=24;
		if(M>59) {
			M=0;
			H+=1;
		}
		H*=60;//시간을 분단위로 변환함
		total=H+M;//전체 시간
		total-=45;//45분 앞서는 시간으로 바꿈
		
		H=total/60;
		M=total-H*60;
		
		System.out.println(H+" "+M);
		
	}

}
