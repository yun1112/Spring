package prac; //10952번

import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B,sum=0;
		A = sc.nextInt();
		B = sc.nextInt();
		//sc.close();
		
		ArrayList<Integer> arr=new ArrayList<Integer>();

		while (true) {
			if (A == 0 && B == 0)
				break;
			
//			System.out.println(A + B);
			
			sum=A+B;
			arr.add(sum);
			
			A=sc.nextInt();
			B=sc.nextInt();
			
		}
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	

}
