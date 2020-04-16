package example;

import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
//		int n;
//		Scanner sc = new Scanner(System.in);
		boolean chk;
//		n = sc.nextInt();
//		chk = isPrime(n);
//		System.out.println(chk);

		for (int i = 1; i <= 100; i++) {
			if (isPrime(i) == true)
				System.out.print(i + " ");
		}
	}

	public static boolean isPrime(int a) {
		boolean check = false;
		int count = 0;
		for (int i = 2; i < a; i++) {
			if (a % i == 0)
				count++;
		}
		if (count == 0)
			check = true;
		return check;
	}
}
