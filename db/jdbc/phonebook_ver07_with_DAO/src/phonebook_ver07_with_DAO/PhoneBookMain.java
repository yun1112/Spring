package phonebook_ver07_with_DAO;


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
			while (true) {
				Menu.printMenu();
//				System.out.println("1.대학 2.회사 3.동호회");
//				System.out.println("[입력하고자 하는 번호를 입력해주세요]");
//				System.out.println("------------------------------------------------------------------------------------");
				try {
					int select = Integer.parseInt(kb.nextLine());// 공백 문제 해결
					if (!(select >= Choice.UNIV && select <= Choice.CAFE)) {
						UserException e = new UserException("입력 문제 발생");
						throw e;
					}
					
					

				} catch (NumberFormatException e) {
					System.out.println("[올바른 번호를 입력해주세요]");
					continue;
				} catch (UserException e) {
					System.out.println("[올바른 번호를 입력해주세요]");
					continue;
				} catch (Exception e) {
					System.out.println("[올바른 번호를 입력해주세요]");
					continue;
				} finally {
//					kb.hasNextLine();
				}
				break;
			}
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
//				manager.showAllInfo();
				manager.phonebookList();
				break;
			case Choice.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
			}
		}

	}

}