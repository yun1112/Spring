package prac2;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int check;

		while (true) {
			Menu.printMenu();
			check = sc.nextInt();
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
