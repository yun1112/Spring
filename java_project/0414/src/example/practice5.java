package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice5 {

	public static void main(String[] args) {
		int N,X;
//		int []A=new int[3];
		ArrayList<Integer> arr=new ArrayList<Integer>();
		//arr.add
		//arr.get(index) 특정 index값 추출
		//arr.size()
		//arr.remove(obj)
		//arr.remove(index)
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		X=sc.nextInt();
//		sc.close();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
			if(arr.get(i)<X)
				System.out.print(arr.get(i)+" ");
		}
		
	}

}
