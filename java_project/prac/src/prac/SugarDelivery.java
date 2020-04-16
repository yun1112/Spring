package prac;

import java.util.Scanner;

public class SugarDelivery {

	public static void main(String[] args) {
		int N, cnt1 = 0, cnt2 = 0, temp = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

//		if (N % 3 == 0) {
//			cnt1 = N / 3;
//			if(N%5==0) {
//				cnt1=(N/5)+((N%5)/3);
//			}
//		}else if (N % 5 == 0) {
//			cnt2 = N / 5;
//		} else {
//			System.out.println("-1");
//		}

		if (N % 5 == 0) {
			cnt1 = N / 5;
			for (int i = cnt1; i > 0; i--) {
				temp = N - (i * 5);
				if (temp % 3 == 0) {
					System.out.println(i + (temp / 3));
					return;
				}
			}

			if (N % 3 == 0)
				System.out.println(N / 3);
			else
				System.out.println(-1);
//		min = cnt1 < cnt2 ? cnt1 : cnt2;
//		System.out.println(min);
		}

	}
}
