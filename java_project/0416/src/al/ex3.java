package al;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int res;
		int remain[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < remain.length; i++) {
			remain[i] = arr[i] % 42;
//			System.out.println(remain[i]);
		}
//		System.out.println("서로 다른 나머지 개수");
		res = howMany(remain);
		System.out.println(res);
	}

	// 중복을 제거해서 새로운 배열 res에 저장하는 메서드
	public static int howMany(int arr[]) {
		int size = arr.length;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])// 중복되는 숫자가 있을 경우 배열에 -1 저장
					arr[i] = -1;
			}
		}

//		System.out.println("중복 제거 후");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
//				System.out.println(arr[i]);
				count++;
			}

		}
		return count;
	}

	public static int count(int arr[]) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] != arr[j])
					count++;
			}

			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j])
					continue;
			}
		}
		return result;
	}

}
