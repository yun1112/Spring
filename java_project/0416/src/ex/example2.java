package ex;

import java.util.Calendar;
import java.util.Scanner;

public class example2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		abs(a,b);
	}
	
	public static void abs(int a,int b) {
		a=(a<0)?-a:a;
		b=(b<0)?-b:b;
		System.out.println(a+" "+b);
	}

}
