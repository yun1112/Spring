package ex;

import java.util.Date;
import java.util.Scanner;

public class KeyboardScanning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date date = new Date();
		System.out.println("숫자를 입력해주세요");
		int n1=sc.nextInt();
		System.out.println("숫자를 입력해주세요");
		int n2=sc.nextInt();
		System.out.println("숫자를 입력해주세요");
		int n3=sc.nextInt();
		int sum=n1+n2+n3;
		System.out.printf("입력된 정수 %d, %d, %d 입니다. 숫자들의 합은 %d입니다",n1,n2,n3,sum);
		
	}
}
