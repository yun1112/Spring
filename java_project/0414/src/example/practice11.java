package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice11 {

	public static void main(String[] args) {
		int max = 1, temp,index=0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr.add(sc.nextInt());
		}
		max=arr.get(0);
		
		for (int i = 1; i < 9; i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
				index=i;
			}
		}
		index++;
		System.out.println(max);
		System.out.println(index);
	}

}
