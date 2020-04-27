package prac04;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int type;

		while (true) {
			Menu.printMenu();
			manager.chooseType();
			Menu.printMainMenu();
			type = sc.nextInt();
			switch (type) {
			case 1:
				manager.EnterData();
				break;
			case 2:
				manager.modifyData();
				break;
			case 3:
				manager.deleteData();
				break;
			case 4:
				manager.searchData();
				break;
			case 5:
				manager.showAllData();
				break;
			case 6:
				return;
			default:
				break;

			}
		}

	}

}
