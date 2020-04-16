package al;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		int arr[] = new int[1000];
		double avg[] = new double[1000];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < N; j++) {

				arr[i] = sc.nextInt();
			}
		}for (int i = 0; i < C; i++) {
//			for (int j = 0; j < arr; j++) {

				System.out.println(arr);
			}
//		}
	}

}
