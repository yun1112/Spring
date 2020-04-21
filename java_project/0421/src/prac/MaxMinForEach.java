package prac;

import java.util.Scanner; //문제 4번

public class MaxMinForEach {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int min, max;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		min = miniValue(arr);
		max = maxValue(arr);

		System.out.printf("배열의 최솟값: %d, 배열의 최댓값: %d", min, max);
	}

	public static int miniValue(int[] arr) {
		int min = arr[0];
		for (int n : arr) {
			if (n < min)
				min = n;
		}
		return min;
	}

	public static int maxValue(int[] arr) {
		int max = arr[0];

		for (int n : arr) {
			if (n > max)
				max = n;
		}
		return max;
	}
}
