package prac;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPrac {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			System.out.println("이름 입력");
			String s=sc.next();//문자열 입력받음
			a.add(s);// Arraylist에 문자열s 추가함
			System.out.println(s);
		}
		for (int i = 0; i < a.size(); i++) {//ArrayList a의 크기만큼 for문 반복함
			String name=a.get(i);//ArrayList a에서 해당하는 인덱스에 맞는 문자열 꺼내서 문자형 변수 name에저장함
			System.out.println(name+" ");
		}
		
		int longIndex=0;//ArrayList a에 저장된 나머지 변수와 값을 비교할 때 사용할 인덱스 0
		for (int i = 1; i < a.size(); i++) {//인덱스 번호0에 저장된 변수와 비교할 나머지 변수
			if(a.get(longIndex).length()<a.get(i).length())//
				longIndex=i;//가장 긴 이름의 인덱스 저장
		}
		System.out.println("가장 긴 이름은 "+a.get(longIndex));
	}

}
