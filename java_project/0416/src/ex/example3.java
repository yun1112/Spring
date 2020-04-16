package ex;

import java.util.Calendar;
import java.util.Scanner;

public class example3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		System.out.println("원의 둘레: "+Circle1(r)); 
		System.out.println("원의 넓이: "+Circle2(r)); 
	}
	
	public static double Circle1(int r) {//원의 둘레 계산하는 메서드
		return  2*Math.PI*r;
	}
	public static double Circle2(int r) {//원의 넓이 계산하는 메서드
		return Math.PI*Math.pow(r, 2);
	}

}
