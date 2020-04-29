package ver05;

import java.util.InputMismatchException;
import java.util.Scanner;

import ver05_exception.BadNumberException;

public class PhoneBookMain {

	public static void main(String[] args) {
//		PhoneBookManager manager = new PhoneBookManager(100);// private처리 되어 있기 때문에 여기에서(외부 클래스) 생성 불가
		PhoneBookManager manager = PhoneBookManager.getInstance();
		Scanner kb = new Scanner(System.in);
		int select = 0;

		while (true) {
			Menu.showMenu();

			try {
				select = manager.kb.nextInt();

				// 정상 범위 1~6
				// MenuNum.INSERT~MenuNum.EXIT
				if (!(select >= MenuNum.INSERT && select <= MenuNum.EXIT)) {
					BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 경우입니다\n다시 확인 후 입력해주세요");
					
					//강제적인 예외 발생
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n확인하시고 다시 입력해주세요");
//				manager.kb.nextLine();
				continue;
			}catch(BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다\n다시 확인 후 입력해주세요");
				continue;
			}catch (Exception e) {// 예외처리도 다형성 적용됨
				System.out.println("잘못된 메뉴 입력입니다");
				continue;
			} finally {
				manager.kb.nextLine();
			}

			switch (select) {
			case MenuNum.INSERT:
				manager.createInfo();
				break;
			case MenuNum.SEARCH:
				manager.searchInfo();
				break;
			case MenuNum.DELETE:
				manager.deleteInfo();
				break;
			case MenuNum.EDIT:
				manager.editInfo();
				break;
			case MenuNum.PRINT_ALL:
				manager.showAllInfo();
				break;
			case MenuNum.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				break;
			}
		}

	}

}
