package prac;

import java.util.Scanner;

//이차원 배열 행단위 시프트
public class ShiftPrac {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("행과 열의 수 입력");
		System.out.println("행의 수 입력");
		int N=sc.nextInt();
//		int M=sc.nextInt();
		int [][]arr=new int[N][N];
		System.out.println("-----------------------------------------------------------");
		System.out.println("행 시프트 전");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]=i*N+j;
			}
		}
		printAll(arr);
		System.out.println("-----------------------------------------------------------");
		System.out.println("행 시프트 후");
		ShiftArr(arr);
		printAll(arr);
	}

	public static void ShiftArr(int[][] arr) {
		int tmp[] = arr[arr[0].length-1];
		for (int i = arr[0].length - 1; i > 0; i--) {// 행 거꾸로 시프트
			arr[i] = arr[i - 1];
		}
		arr[0]=tmp;
	}
	public static void printAll(int[][]arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
