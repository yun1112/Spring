package examples.copy;

import java.util.Scanner;

/*
사원관리프로그램
기능
	1.입력
	2.수정(이름,부서,급여)
	3.삭제(사원번호pk기준)
	4.리스트(전체)
	5.검색(이름기준)
	
부서관리프로그램
기능
	1.입력
	2.수정(부서이름,위치)
	3.삭제(부서번호pk기준)
	4.리스트(전체)
	5.검색(부서이름 or 지역기준)
*/
public class management_of_main {

	public static void main(String[] args) {
		management_of_emp e = new management_of_emp();
		management_of_dept d = new management_of_dept();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------------------------------");
			System.out.println("관리할 정보 선택");
			System.out.println("1.사원 2.부서 3.종료");
			System.out.println("----------------------------------");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				e.main(args);
				break;
			case 2:
				d.main(args);
				break;
			case 3:
				System.exit(0);
			}
		}

	}

}
