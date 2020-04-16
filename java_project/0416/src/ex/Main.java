package ex;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Triangle t = new Triangle();
		int weight = sc.nextInt();
		int height = sc.nextInt();
		t.setTriangle(weight, height);
		int result = t.calTriangle(weight, height);
		System.out.println(result);
	}

}
