package al;//정수 배열의 중복 제거

import java.util.ArrayList;
import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Remove rm=new Remove();
		int []arr=new int [10];
		int []res=new int [10];
		for (int i = 0; i < 10; i++) {
			arr[i]=sc.nextInt();
		}
		res=rm.repetition(arr);
	}
	public static class Remove{
		public int[] repetition(int  []arr) {
			int [] answer= {};
			ArrayList<Integer> arrList=new ArrayList<>();
			int temp=10;
			for(int num:arr) {
				if(temp!=num)
					arrList.add(num);
				temp=num;
			}
			answer=new int[arrList.size()];
			for (int i = 0; i < arrList.size(); i++) {
				answer[i]=arrList.get(i);
				System.out.println(answer[i]);
			}
			return answer;
		}
	}
}
