package example;

import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();

		Quadrant(x, y);
	}

	public static void Quadrant(int x, int y) {

		if (x > 0 && x<=1000) {
			if (y > 0 && y<=1000)
				System.out.println(1);
			else if (y < 0 && y>=-1000)
				System.out.println(4);
		} else if (x < 0 && x>=-1000) {
			if (y > 0 && y<=1000)
				System.out.println(2);
			else if (y < 0 && y>=-1000)
				System.out.println(3);
		}

	}

}
