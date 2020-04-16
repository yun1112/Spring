package ex;

import java.util.Scanner;

public class example4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean check = false;
		if (isPrime(num) == true)
			System.out.println("입력한 숫자는 소수입니다");
		else
			System.out.println("입력한 숫자는 소수가 아닙니다");

		System.out.println("--------------------------");
		System.out.println("1이상 100 이하의 소수");
		for (int i = 1; i <= 100; i++) {
			check = isPrime(i);
			if (check == true)
				System.out.print(i + " ");
		}

	}

	public static boolean isPrime(int num) {
		boolean result = false;
		int count = 0;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				count++;
		}
		if (count == 0)
			result = true;

		return result;
	}
}
