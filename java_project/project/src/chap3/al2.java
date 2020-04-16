package chap3;

import java.util.Scanner;

public class al2 {

	public static void main(String[] args) {
		int a, b, temp;
		int arr[] =new int[5];
		Scanner sc = new Scanner(System.in);
		//a=sc.nextInt();
		//b=sc.nextInt();
		
		for (int i = 0; i < 5; i++) {
			arr[i]=sc.nextInt();
		}
		
		for (int i = 0; i <4 ; i++) {
			for (int j = i+1; j <5 ; j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
					
			}
		}
		
		System.out.println(arr[4]);
		
//		temp = a;
//		a = b;
//		b = temp;
//
//		for (int i = 0; i < 5; i++) {
//			arr[i] = sc.nextInt();
//		}
//		for (int i = 0; i < 4; i++) {
//			for (int j = i + 1; j < 5; j++) {
//				if(arr[i]<)
//			}
//		}


	}

}//2 3 4 5
