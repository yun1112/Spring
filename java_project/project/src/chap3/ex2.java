package chap3;

import java.util.Scanner;//

public class ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num < 0)
			System.out.println("0미만");
		else if (num < 100)
			System.out.println("0이상 100 미만");
		else if (num < 200)
			System.out.println("100이상 200 미만");
		else if (num < 300)
			System.out.println("200이상 300미만");
		else
			System.out.println("300이상");
	}

}
