package ex;

import java.util.Scanner;

public class benefit {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();//고정 비용
		int B=sc.nextInt();//가변 비용
		int C=sc.nextInt();//노트북 가격
		int break_even_point;//손익분기점
		int price=A;
		int i=0;
		//판매 비용>(고정비용+가변비용)
		//C>(A+B)
		while(true) {
			price+=B*i;
			i++;
			if(C>price)
				break;
		}
		break_even_point=price;
		System.out.println(break_even_point);
	}

}
