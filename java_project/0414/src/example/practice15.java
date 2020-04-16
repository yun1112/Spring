package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice15 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<String> arr=new ArrayList<String>();
		int N=sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr.add(sc.next());//문자열 입력받아서 배열arr에 저장
		}//next()로 입력받아야 함
		System.out.println(arr.get(0));
	}

}
