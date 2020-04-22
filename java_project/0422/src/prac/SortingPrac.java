package prac;

import java.util.Scanner;

public class SortingPrac {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 개수 입력");
//		int N = sc.nextInt();
//		int[] arr = new int[N];
//		System.out.printf("%d개 정수 입력", N);
//		for (int i = 0; i < N; i++) {
//			arr[i] = sc.nextInt();
//		}

//		System.out.println("버블정렬 후");
//		BubbleSorting(arr);
//		printAll(arr);
//		System.out.println("\n--------------------------------------------------------------------");
//		System.out.println("셔플 후");
//		ShuffleAll(arr);
//		printAll(arr);
//		System.out.println("\n--------------------------------------------------------------------");
//		System.out.println("선택정렬 후");
//		SeletionSorting(arr);
//		printAll(arr);
//		
		System.out.println("\n--------------------------------------------------------------------");
		System.out.println("문자열 입력");
		String str = sc.next();

		System.out.println("문자열 역순 출력");
		System.out.println("\n--------------------------------------------------------------------");
		ReverseAll(str);
	}

	public static void ReverseAll(String str) {
		// 1.StringBuffer reverse()메서드 이용
		StringBuffer sb=new StringBuffer(str);
		sb.reverse();
		System.out.println(sb);

		// 2.unicode & indexOf(char ch)이용

		// 3.String charAt()메서드 이용//replace()메서드 이용
//		for (int i = str.length() - 1; i >= 0; i--) {
//		for (int i = 0; i < str.length(); i++) {
//			str.replace(str.charAt(i), str.charAt(str.length() - 1 - i));
//		}
//		System.out.println(str);
	}
	


	public static void ShuffleAll(int[] arr) {
		final int COUNT = 10000;
		int tmp;
		int rand;
		for (int i = 0; i < COUNT; i++) {
			rand = (int) (Math.random() * arr.length);
			tmp = arr[0];
			arr[0] = arr[rand];
			arr[rand] = tmp;
		}
	}

	public static void SeletionSorting(int[] arr) {
		int tmp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void BubbleSorting(int[] arr) {
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	public static void printAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
