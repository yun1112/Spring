package chap3;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int check = 0;
		if (num < 0)
			check = 0;

		else if (num < 100)
			check = 1;
		else if (num < 200)
			check = 2;
		else if (num < 300)
			check = 3;
		else
			check = 4;

		switch (check) {
		case 0:
			System.out.println("0미만");
			break;
		case 1:
			System.out.println("0이상 100 미만");
			break;
		case 2:
			System.out.println("100이상 200 미만");
			break;
		case 3:
			System.out.println("200이상 300미만");
			break;
		case 4:
			System.out.println("300이상");
		default:
			break;
		}
	}
}
