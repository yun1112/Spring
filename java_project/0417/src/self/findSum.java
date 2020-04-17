package self;

import java.util.Scanner;

public class findSum {
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[1000000];
		int nums[] = new int[1000000];

		int n = sc.nextInt();
		int result = 0;
		int count = 0;
		boolean check = false;// 등차수열 여부 알려주는 변수
		int index = 0;
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		while (true) {
			arr[index] = n % 10;
			n /= 10;
			index++;

			if (n <= 0)
				break;
		}
		for (int i = 0; i < index; i++) {
			System.out.println(arr[i]);// 숫자n의 각 자리수에 해당하는 숫자 하나씩 배열 arr에 저장
		}
//		result = Sum(arr);// 배열의 합
//		System.out.println(result);

		check = check(arr, index);

		if (check == true)
			System.out.println("해당하는 숫자는 한수입니다");
		else
			System.out.println("해당하는 숫자는 한수가 아닙니다");

		// 1부터 N까지 한수 개수
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;// 1~N값이 저장되어 있는 배열 nums
		}

		if (check(nums, n) == true)
			count++;
		System.out.println("한수의 개수:" + count);

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

			}
		}

	}

	// 숫자 각 자리수를 저장하는 배열을 만드는 함수
	public static int[] Num(int num) {
		int result[] = {};
		int index = 0;
		while (true) {
			result[index] = num % 10;
			num /= 10;
			index++;
			if (num <= 0)
				break;

		}
		return result;//배열 반환
	}

	public static int Sum(int arr[]) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	public static boolean check(int arr[], int index) {// 숫자배열 전체의 등차수열 여부를 알려주는 메서드
		boolean result = false;
		int dif = 0;// 연속하는 두 수의 차이값을 저장하는 변수
		for (int i = 0; i < index - 2; i++) {
			dif = Math.abs(arr[i] - arr[i + 1]);// 연속하는 두 수의 차이
//			System.out.println("dif1"+dif);
			if (Math.abs(arr[i + 2] - arr[i + 1]) == dif) {// 그 다음 두 수의 차이도 같을 경우
				result = true;
//				System.out.println("dif2:"+Math.abs(arr[i + 2] - arr[i + 1]));
			} else {
				result = false;
				return result;// 해당하는 배열은 등차수열로 이루어져 있지 않으므로 result 반환
			}
//			System.out.println("arr"+arr[i]);
		}
		return result;
	}

}
