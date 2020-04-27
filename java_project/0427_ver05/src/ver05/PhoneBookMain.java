package ver05;

//2.interface기반의 상수 표현->이름에 부여된 상수 기반으로 메뉴 선택
import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
//		PhoneBookManager manager = new PhoneBookManager(100);
		//싱글톤 패턴 적용 후
		PhoneBookManager manager = PhoneBookManager.getInstance();
		Scanner kb = new Scanner(System.in);

		while (true) {
			Menu.printMainMenu();
//			int select = manager.kb.nextInt();
//			manager.kb.nextLine();
			switch (kb.nextInt()) {
			case Choice.CREATE:
				manager.createInfo();
				break;
			case Choice.EDIT:
				manager.editInfo();
				break;
			case Choice.DELETE:
				manager.deleteInfo();
				break;
			case Choice.SEARCH:
				manager.searchInfo();
				break;
			case Choice.SHOW:
				manager.showAllInfo();
				break;
			case Choice.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				break;
			}

		}

	}

}