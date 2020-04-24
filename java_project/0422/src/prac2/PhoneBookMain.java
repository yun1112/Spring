package prac2;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int check;
		int type;
		while (true) {
			Menu.printChoice();
			//타입 선택하는 메서드 호출
			manager.typeChoice();
			sc.nextLine();
			Menu.printMenu();
			System.out.println("수행하고자 하는 업무 선택");
			check = sc.nextInt();
			
			//type=1이면 PhoneUnivInfor 인스턴스 생성
			
//			type=manager.typeChoice();
			switch (check) {
			case 1:
				manager.createInstance(); 
				break;
			case 2:
				manager.searchInfor();
				break;
			case 3:
				manager.deleteInfor();
				break;
			case 4:
				manager.showAllData();
				break;
			case 5:
				return;

			}
		}
	}

}
