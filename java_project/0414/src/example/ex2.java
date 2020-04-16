package example;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		int a,b;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		
		abs(a,b);
	}
	public static void abs(int a, int b) {
		int aa,bb;
		aa=a<0?-a:a;
		bb=b<0?-b:b;
		System.out.println(a+"의 절댓값은 "+aa+"입니다.");
		System.out.println(b+"의 절댓값은 "+bb+"입니다.");
	}
}
