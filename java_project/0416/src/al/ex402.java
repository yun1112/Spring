package al;//OX점수

import java.util.Scanner;
public class ex402 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int total[]= {};
		int N=sc.nextInt();
		String[] cases=new String[N];//각각의 결과값을 담을 문자열 배열
		for (int i = 0; i < N; i++) {
			cases[i]=sc.next();//Enter누를때까지 하나씩 입력받음
		}
		sc.close();//스캐너 닫음
		total=resultOX(cases);
		
	}
	public static int[] resultOX(String[] arr) {
		int count,total=0;
		int res[]= {};
		int j=0;
		for (String OXresult:arr) {//cases 문자열 배열에 있는 각각의 문자열 비교
			count=0;
			total=0;
			for (int i = 0; i < OXresult.length(); i++) {
				if(OXresult.charAt(i)=='O') {//OXresul 문자열에 있는 문자 하나가 'O'일 경우
					total+=++count;
				}else
					count=0;
			}
			res[j]=total;
			j++;
		}

		return res;
	}

}
