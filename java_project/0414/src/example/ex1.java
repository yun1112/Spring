package example;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();

		calculator(a, b);
	}

	public static void calculator(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
		System.out.println(a + "-" + b + "=" + (a - b));
		System.out.println(a + "*" + b + "=" + (a * b));
		System.out.println(a + "/" + b + "=" + (float) (a / b)+"\n몫:"+(a/b)+" ,나머지:"+(a%b));

	}

}
