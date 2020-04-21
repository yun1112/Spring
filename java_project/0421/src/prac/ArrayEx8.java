package prac;

import java.util.Scanner;

public class ArrayEx8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		Reverse(str);
	}
	public static void Reverse(String str) {

		for (int i=str.length()-1; i>=0;i--) {
			System.out.print(str.charAt(i));
		}
	}
}
