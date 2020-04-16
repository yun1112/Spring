package prac;

import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int num,sum=0;
		 String nums;
		 num=sc.nextInt();
		 nums=sc.next();//문자열 입력받음
		 sc.close();//입력 종료
		 for (int i = 0; i < num; i++) {
			sum+=nums.charAt(i)-'0';
		}
		 System.out.println(sum);
	}

}

/*
 * String nextLine(); // '\n'을 포함하는 한 라인을 읽고 '\n'을 버린 나머지만 리턴
 * void close(); Scanner의 사용 종료
 * boolean hasNExt(); 현재 입력된 토큰이 있으면 true, 아니면 새로운 입력이 들어올 때까지 무한정 기다려서
 * 새로운 입력이 들어오면 그 때 true 리턴. ctrl+z가 입력되면 끝이므로 false 리턴
 */