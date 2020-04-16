package chap3;

import java.util.Scanner;

public class al1 {

	public static void main(String[] args) {
		int a,b,result;
		Scanner sc=new Scanner(System.in);
		System.out.println("숫자1 입력");
		a=sc.nextInt();
		System.out.println("숫자2 입력");
		b=sc.nextInt();
		
		result=(a>b)?a:b;
		System.out.println("큰 수는"+result+"입니다.");
	}

}
