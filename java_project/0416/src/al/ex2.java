package al;

import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> mul = new ArrayList<Integer>();
		int arr[] = new int[3];//숫자 세 개 입력받아 저장하는 배열
		int count[] = new int[10];//0~9까지 숫자 개수를 저장할 배열
		int result = 1;//세 숫자의 곱
		int size = arr.length;//배열 arr 크기
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			result *= arr[i];
		}
		// 이제 배열 arr 필요없음
		//ArrayList mul에 곱셈 결과 result의 숫자를 거꾸로 하나씩 저장함
		while (true) {
			if (result <= 0)
				break;

			mul.add(result % 10);
			result /= 10;

		}
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < mul.size(); j++) {
				if(i==mul.get(j)) {
					count[i]++;
				}
			}
			System.out.println(count[i]);
		}
		
		
//		}
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < size; j++) {
//				if(arr[j]==i) {
//					size--;
//					count[i]++;
//					
//				}
//			}
//		}
//	}
	}
}