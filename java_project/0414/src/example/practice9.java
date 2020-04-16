package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B, C, temp;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		arr.add(A);
		arr.add(B);
		arr.add(C);
		
		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i) < arr.get(j)) {
					temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
		System.out.println(arr.get(1));
	}

}
