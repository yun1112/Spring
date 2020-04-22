package prac;

import java.util.Scanner;

public class PhoneBookMain3 {

	public static void main(String[] args) {
		PhoneBookManager3 manager=new PhoneBookManager3();
		int check;
		Scanner sc=new Scanner(System.in);
		
		Menu3.printMenu3();
		
		while(true) {
			check=sc.nextInt();
			
			switch(check) {
			case 1://저장
				manager.saveData();
				break;
			case 2://검색
				manager.searchData();
				break;
			case 3://삭제
				manager.deleteData();
				break;
			case 4://출력
				manager.showAllData();
				break;
			case 5://종료
				return;
			}
		}
	}

}
