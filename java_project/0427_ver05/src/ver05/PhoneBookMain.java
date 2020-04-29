package ver05;

import java.util.InputMismatchException;
//2.interface기반의 상수 표현->이름에 부여된 상수 기반으로 메뉴 선택
import java.util.Scanner;


public class PhoneBookMain {

	public static void main(String[] args) {
//		PhoneBookManager manager = new PhoneBookManager(100);
		// 싱글톤 패턴 적용 후
		PhoneBookManager manager = PhoneBookManager.getInstance();
		Scanner kb = new Scanner(System.in);
		int type = 0;
		while (true) {
			Menu.printMainMenu();
//			int select = manager.kb.nextInt();
//			manager.kb.nextLine();
			try {
				type =Integer.parseInt(kb.nextLine());
				if (!(type >= Choice.CREATE && type <= Choice.EXIT)) {
					UserException e = new UserException("메뉴 범위를 벗어나는 경우입니다\n다시 확인 후 입력해주세요");
					
					//강제적인 예외 발생
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n확인하시고 다시 입력해주세요");
//				manager.kb.nextLine();
				continue;
			}catch(UserException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다\n다시 확인 후 입력해주세요");
				continue;
			}catch (Exception e) {// 예외처리도 다형성 적용됨
				System.out.println("잘못된 메뉴 입력입니다");
				continue;
			} finally {
//				manager.kb.nextLine();
			}

			switch (type) {
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
			}
		}

	}

}