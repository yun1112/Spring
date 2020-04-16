package example; //2577번 숫자의 개수

import java.util.ArrayList;
import java.util.Scanner;

public class practice12 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>(10);
		Scanner sc = new Scanner(System.in);
		int A, B, C, result;
		int index = 0, count = 0;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		result = A * B * C;

		while (true) {
			arr.add(result % 10);// 1의자리 숫자부터 하나씩 ArrayList에 저장
			result /= 10;
			if (result <= 0)
				break;
			System.out.println(arr.get(index));
			index++;
		}
		arr.add(result % 10);
		System.out.println(arr.get(index));

		for (int i = 0; i < 10; i++) {
			count = 0;
			for (int j = 0; j < arr.size(); j++) {
				if (i == arr.get(j))
					count++;
			}
			res.set(i, count);
			System.out.println(count);
		}
	}

}
