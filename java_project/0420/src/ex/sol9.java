package ex;//charAt() 사용

import java.util.Scanner;

public class sol9 {//Integer.parseInteger();

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str = new String(sc.next());
		int num=Integer.parseInt(str);
		int sum=0;
		System.out.println(num);
		for (int i = 0; i < str.length(); i++) {
			//sum+=(int)str.charAt(i);//char형 문자 ascii code값으로 변환함
			sum+=Character.getNumericValue(str.charAt(i));// char형 문자값을 int형 정수값으로 변환함
//			System.out.println("sum="+sum);
		}
		
		System.out.println(sum);
	}

}


/*
 * 문자열->숫자 변환
 * 1.Integer.valueOf()
 * 2.Integer.parseInt()
 */