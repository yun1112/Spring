package prac;

import java.util.Scanner;

//중복되는 숫자 개수
public class ArrayEx6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("배열에 저장할 숫자 개수 입력");
		int N=sc.nextInt();
		int []arr=new int[N];
		System.out.printf("%d개의 숫자 입력",N);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int []res=new int[N];
		res=Count(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.printf("숫자%d: %d개\n",i,res[i]);
		}
	}
	public static int[] Count(int[]arr) {
		int[] count=new int[arr.length-1];
//		for (int i = 0; i < count.length; i++) {
//			count[i]=0;
//		}
		
		for (int i = 0; i < arr.length; i++) {// ex) arr={1 ,2 ,2 ,5}
			count[arr[i]]++;// ex) count[arr[0]]->count[1]-> count[1]++-> 숫자 1이 1개 있음
		}
		
		return count;
	}

}
