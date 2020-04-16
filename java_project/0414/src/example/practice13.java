package example;

import java.util.ArrayList;
import java.util.Scanner;

public class practice13 {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<Integer>(10);
		ArrayList<Integer> remain=new ArrayList<Integer>(10);
		Scanner sc=new Scanner(System.in);
		int A,B,count=0;
		for (int i = 0; i < 10; i++) {
			arr.add(sc.nextInt());
			//remain.set(i, arr.get(i)%42);//42로 나눈 나머지로 이루어진 ArrayList remain 값 설정
			//System.out.println(remain.get(i));
			
//			remain.set(i, (arr.get(i)%42)); // set하면 오류남
			remain.add(arr.get(i)%42);
//			System.out.println("remain:"+arr.get(i)%42);
		}
		
		int len1=9,len2=10;
		for (int i = 0; i < len1; i++) {
			for (int j = i+1; j < len2; j++) {
				if(remain.get(i)==remain.get(j)) {
					remain.remove(j);
					len1--;
					len2--;
				}
			}
		}
//		
//		for (int i = 0; i < remain.size(); i++) {
//			System.out.println(remain.get(i));
//		}
//		
		count=remain.size();
		System.out.println(count);
	}

}
