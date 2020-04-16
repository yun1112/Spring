package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice10 {

	public static void main(String[] args) {
		int N,min=1000000,max=-1000000,temp;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(arr.get(i)<arr.get(j)) {
					temp=arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
		
		min=arr.get(N-1);
		max=arr.get(0);
		System.out.println(min+" "+max);
	}

}
