package chap3;

import java.util.Scanner;

public class assignment8 {

	public static void main(String[] args) {
		int answer = (int) (Math.random() * 10) + 1;
		int input = 0, count = 0;
		Scanner s = new Scanner(System.in);

		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 :");
			input = s.nextInt();

			if (input == answer) {
				System.out.println("맞췄습니다.");

				break;
			}

			else if (input < answer)
				System.out.println("더 큰 수를 입력하세요.");
			else
				System.out.println("더 작은 수를 입력하세요.");

		} while (true);

		System.out.println("시도횟수는 "+count+"번입니다.");
	}
}
