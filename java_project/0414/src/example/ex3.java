package example;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		int r;
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();

		System.out.println("원의 둘레:" + circle1(r));
		System.out.println("원의 넓이:" + circle2(r));

	}

	public static double circle1(int r) {
		return (2 * Math.PI * r);
	}

	public static double circle2(int r) {
		return (Math.PI * Math.pow(r, 2));
	}
}
