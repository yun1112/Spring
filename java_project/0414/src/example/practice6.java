package example;

import java.util.Scanner;

public class practice6 {

	public static void main(String[] args) {
		int N, a, b, new_num, count = 1, original = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		original = N;
		
		a=N/10;
		b=N%10;
		
		while (true) {
			
			new_num=b*10+(a+b)%10;
			
			a = b;
			b =new_num % 10;
			
			new_num = a*10 + b;// 새로운 수
			
			if (new_num == original)
				break;
			
			count++;
		}
		System.out.println(count);
	}

}
