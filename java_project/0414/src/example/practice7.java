package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice7 {

	public static void main(String[] args) {
//		double avg=0.0;
		int avg = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> students = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			students.add(sc.nextInt());// 학생 5명 점수 입력받음
			if (students.get(i) < 40)
				students.set(i, 40);
//				students.add(40);// ArrayList 값 변경할 떄는 set해야됨
			System.out.println(students.get(i));
		}
//		avg/=5.0f;
		for (int i = 0; i < 5; i++) {
			avg += students.get(i);

		}
		avg /= 5;
		System.out.println(avg);

	}

}
