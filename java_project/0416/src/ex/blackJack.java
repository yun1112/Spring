package ex;

import java.util.Scanner;

public class blackJack {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[100];
		int dif[]=new int[100];//M과의 차이값 저장하는 배열
		int N=sc.nextInt();
		int M=sc.nextInt();
		int temp=0;
		int sum=0;
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		dif=arr;
//		System.out.println(N+" "+M);
		for (int i = 0; i < N; i++) {
			dif[i]=(arr[i]-M)<0? -(arr[i]-M):(arr[i]-M);//M과의 차이 절댓값량 diff배열에 저장
//			System.out.println(dif[i]);
		}
		
		for (int i = 0; i < N-1; i++) {// 차이값이 저장되어 있는 diff배열 내림차순으로 정렬
			for (int j = i+1; j < N; j++) {
				if(dif[i]<dif[j]) {
					temp=dif[i];
					dif[i]=dif[j];
					dif[j]=temp;
				}
			}
		}

		System.out.println("정렬 후");
		for (int i = 0; i < N; i++) {
			System.out.print(dif[i]+" ");
		}
		
		for (int i = 0; i < 3; i++) {
			sum+=dif[i];
		}
		System.out.println("" );
		System.out.println(sum);
	}

}
