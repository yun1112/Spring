package example;

import java.util.Scanner;

public class practice4 {

	public static void main(String[] args) {
		int N, i = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		while (true) {
			if (i == N)
				break;
			for (int j = 0; j <= N - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
			i++;
		}
	}

}
