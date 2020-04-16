package al;//OX점수

import java.util.ArrayList;
import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		int N=sc.nextInt();
//		ArrayList<String> str =new ArrayList<String>();
//		char arr[]=new char[80];
		int result;
		//split함수 활용해서 단어를 String배열에 한글자씩 저장
		String str=sc.nextLine();
		System.out.println("입력:"+str);
		result=findResult(str);
		System.out.println(result);
		
//		for (int i = 0; i < N; i++) {
////			arr[i]=sc.next();//문자열 하나씩 입력받아서 문자형 배열에 저장
//			str.add(sc.next());
//
//		}
	}
	public static int findResult(String str ) {
		int result = 0, check = 0;
		boolean flag = false;
		char ch=str.charAt(0);//문자열 배열에 있는 문자열 한글자씩 저장
		
		String[] array_res=str.split("");//arry_res배열에 입력받은 문자열 한글자씩 저장
		for (int i = 0; i < array_res.length; i++) {
			System.out.println(array_res[i]);
		} 
		
		for (int i = 1; i < array_res.length; i++) {
			if (flag == false)
				check = 0;
			ch=str.charAt(i);
			if (ch == 'O' &&ch == 'O') {//ArrayList에서 한 문자씩 받아와서 비교함
				check++;
				flag = true;
			} else
				flag = false;
			result += check;

		}
		return result;
	}

}
