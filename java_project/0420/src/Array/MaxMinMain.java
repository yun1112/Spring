package Array;

import java.util.Scanner;

public class MaxMinMain {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int min,max;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		min=miniValue(arr);
		max=maxValue(arr);
		
		System.out.printf("배열의 최솟값: %d, 배열의 최댓값: %d",min,max);
	}

	public static int miniValue(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	public static int maxValue(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}
