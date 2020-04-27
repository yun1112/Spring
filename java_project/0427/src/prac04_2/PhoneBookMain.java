package prac04_2;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneManager manager=new PhoneManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("선택");
		int selection=Integer.parseInt(sc.nextLine());
		
		switch(selection) {
		case 1:
			manager.saveInfo();
			break;
		case 2:
			manager.editInfo();
			break;
		case 3:
			manager.deleteInfo();
			break;
		case 4:
			manager.searchInfo();
			break;
		case 5:
			manager.showAllInfo();
			break;
		case 6:
			return;
		default:
			break;
		}
	}

}
