package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Double> res = new ArrayList<Double>();
		int N = sc.nextInt();
		int M;
		double avg = 0.0;
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
			avg+=arr.get(i);
		}
		M = arr.get(0);
		for (int i = 1; i < N; i++) {
			if (arr.get(i) > M)
				M = arr.get(i);
	
		}
//		avg/=N; //전체 수의 평균
		avg=avg/M*100;
		avg/=N;
		System.out.println(avg);
		
		/*
		 * for (int i = 0; i < N; i++) { res.set(i, (double) arr.get(i) / M * 100); }
		 */
	}

}
