package ex;

import java.util.Calendar;
import java.util.Scanner;

public class example {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		calculator(a,b);
	}
	
	public static void calculator(int a,int b) {
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+((float)a)/b);
		System.out.println("몫: "+(a/b)+" ,나머지:" +(a%b));
	}

}
