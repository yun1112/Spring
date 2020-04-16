package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice8 {

	public static void main(String[] args) {
		int min=2000;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> set = new ArrayList<Integer>();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			arr.add(sc.nextInt());
		}

		for (int i = 0; i < 3; i++) {// 햄버거 3종류
			for (int j = 0; j < 2; j++) {// 음료 2종류
				set.add(arr.get(i) + arr.get(i + 2) - 50);// 세트가격 ArrayList set에 저장

			}
		}
		for (int i = 0; i < set.size(); i++) {
			if(set.get(i)<min)
				min=set.get(i);
		}
		
		System.out.println(min);
	}

}
