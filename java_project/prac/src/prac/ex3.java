package prac;// 1110번 더하기 사이클

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int first=N;
		sc.close();
		int a, b, sum = 0, cycle = 0, new_num;
		a = N / 10;// 10의자리 수
		b = N % 10;// 1의자리 수
		
		System.out.println(a+" "+b);
		if (N < 10)
			N *= 10;// 주어진 숫자를 두자리수로 만듦
		
		N=a+b;
		
		new_num = b*10+N%10;// 새로운 수 만듦
		System.out.println("new number:"+new_num);

		while (true) {
			a=new_num/10;
			b = new_num % 10;// 1의자리 수
			N=a+b;
			
			if (N < 10)
				N *= 10;// 주어진 숫자를 두자리수로 만듦
			
			new_num = b*10+N%10;// 새로운 수 만듦
			System.out.println("new number:"+new_num);

			if(new_num==N)
				break;
			
			cycle++;
		}
		
		System.out.println(cycle);
	}
}
