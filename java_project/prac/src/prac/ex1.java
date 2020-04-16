package prac; // 문제 2581번 소수

import java.util.ArrayList;
import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		int n, m, num, sum = 0, min;
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.close();

		Check chk = new Check();

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = n; i <= m; i++) {
			flag = chk.c(i);// 해당 숫자가 소수인지 아닌지 확인
			if (flag) {
				sum += i;
				// 해당하는 숫자가 소수일 경우 ArrayList에 추가함
				arr.add(i);
			}

		}
		if (sum == 0)
			System.out.println(-1);
		else {

			System.out.println(sum);

			min = chk.min(arr);

			System.out.println(min);
		}
	}

}

class Check {
	private int n;

	public Check() {
		this.n = n;
	}

	public boolean c(int n) {// 해당 숫자가 소수인지 판별하는 메서드
		boolean result = false;
		int flag = 0, count = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		if (count == 1)
			result = true;
		return result;
	}

	public int min(ArrayList<Integer> arr) {// 최솟값을 리턴하는 메서드
		int min;
		Check chk = new Check();
//		ArrayList<Integer> arr=new ArrayList<Integer>();

		min = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) < min)
				min = arr.get(i);
		}

//		Vector<Integer> v = new Vector<Integer>();
//		int arr[] = new int[5];
//
//		for (int i = n; i < m; i++) {
//			if (chk.c(i)) {
////				v.add(new Integer(i));
////				System.out.println(v.get(i));
//
//				v.addElement(new Integer(i));// Vector에서 int값 넣기
////				arr[i]=i;
//			}
//		}
//
//		int tmp = 0;
////		 Vector에서 int갑 얻어오기
//		for (int i = n; i < m; i++) {
//			tmp = ((Integer) v.get(i)).intValue();
//			System.out.println(tmp);
//		}
		return min;
	}

}