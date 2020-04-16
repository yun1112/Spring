package al;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		int arr[]=new int[9];
		int max,order;
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i]=sc.nextInt();
		}
		max=findMax(arr);
		order=findOrder(arr,max);
		System.out.println(max);
		System.out.println(order);
	}
	
	public static int findMax(int arr[]) {
		int max=arr[0];
		for (int i = 1; i <9; i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
	
	public static int findOrder(int arr[],int num) {
		int order=1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==num)
				break;
			order++;
		}
		return order;
		
	}

}
