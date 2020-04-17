package self;

import java.util.Scanner;

public class howMany {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 0;
		int arr[] = new int[1000];
		while (true) {
			arr[n] = N % 10;
			N /= 10;

			n++;
			if (N <= 0)
				break;
		}
		for (int i = 0; i < n; i++) {

		}

		boolean check = check(arr);// 한수 여부
		if (check == true)
			System.out.println("한수");
	}

	public static boolean check(int arr[]) {
		int result = 0;
		int dif;// 등차수열 여부를 판별하기 위해 차이값 저장하는 변수
		boolean flag = false;// 한수 여부를 가려주는 변수
		for (int i = 0; i < arr.length - 2; i++) {
			dif = Math.abs(arr[i] - arr[i + 1]);// 연속하는 두 수의 차이의 절댓값
			if (dif != (arr[i + 2] - arr[i + 1])) {
				flag = false;
				break;
			} else
				flag = true;
		}

		return flag;
	}
}
