package ver05;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
/*
 기존에 배열로 선언되었던 books를 ArrayList로 재정의
 
 */
import java.util.Scanner;

import ver05_exception.BadNumberException;

//PhoneInfo타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {
	static private PhoneBookManager manager = new PhoneBookManager(100);// private 외부 접근 제한

	public static PhoneBookManager getInstance() {
		return manager;
	}

	 ArrayList<PhoneInfo> books;
	Iterator<PhoneInfo> iter;
	Scanner kb;

	private PhoneBookManager(int N) {
		books =new ArrayList<>();
		iter=books.iterator();
		kb = new Scanner(System.in);
	}

	void searchInfo() {
		String name = kb.nextLine();
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).checkName(name))
				books.get(i).showAllInfo();
		}
	}

	void editInfo() {
		String editName = kb.nextLine();
		int index = searchIndex(editName);

		if (index < 0) {
			System.out.println("수정하고자 하는 이름의 정보가 없습니다");
			return;
		} else {
			System.out.println("수정 데이터 입력을 시작합니다");
			System.out.println("이름은 " + editName + "입니다");
			System.out.println("이름을 입력해주세요");
//			String name = kb.nextLine();//이름은 바꾸면 안됨
			System.out.println("전화번호를 입력해주세요");
			String phoneNumber = kb.nextLine();
			System.out.println("주소를 입력해주세요");
			String addr = kb.nextLine();
			System.out.println("이메일을 입력해주세요");
			String email = kb.nextLine();

			PhoneInfo info = null;

			if (books.get(index) instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력해주세요");
				String major = kb.nextLine();
				System.out.println("학점을 입력해주세요");
				String grade = kb.nextLine();
				info = new PhoneUnivInfo(editName, phoneNumber, addr, email, major, grade);
			} else if (books.get(index) instanceof PhoneCompanyInfo) {
				System.out.println("회사를 입력해주세요");
				String company = kb.nextLine();
				System.out.println("부서를 입력해주세요");
				String dept = kb.nextLine();
				System.out.println("직책을 입력해주세요");
				String job = kb.nextLine();
				info = new PhoneCompanyInfo(editName, phoneNumber, addr, email, company, dept, job);
			} else if (books.get(index)instanceof PhoneCafeInfo) {
				System.out.println("동호회 이름을 입력해주세요");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력해주세요");
				String nickName = kb.nextLine();
				info = new PhoneCafeInfo(editName, phoneNumber, addr, email, cafeName, nickName);
			}

			books.set(index, info);
			
			//추가
			iter=books.iterator();
		}

	}

	void deleteInfo() {
		System.out.println("삭제하고자 하는 이름을 입력해주세요");
		String name = kb.nextLine();
		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("삭제하고자 하는 이름의 정보가 없습니다");
		} else {
			books.remove(index);
			iter=books.iterator();//추가
			}
		}


	void createInfo() {

		int select = 0;
		// while문으로 반복처리
		while (true) {
			System.out.println("1.대학 2.회사 3.동호회");
			System.out.println("입력하고자 하는 번호를 입력해주세요");

			try {
				select = Integer.parseInt(kb.nextLine());// 공백 문제 해결
				if (!(select >= MenuNum.UNIV && select <= MenuNum.CAFE)) {
					throw new BadNumberException("잘못된 메뉴 번호 입력");
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n확인하시고 다시 입력해주세요");
//				manager.kb.nextLine();
				continue;
			} catch (BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다\n다시 확인 후 입력해주세요");
				continue;
			} catch (Exception e) {// 예외처리도 다형성 적용됨
				System.out.println("정상적인 선택이 아닙니다\n메뉴를 다시 선택해주세요");
				continue;
			} finally {
//				manager.kb.nextLine();
			}
			break;
		}
		// 기본 정보 수집:이름,전화번호,주소,이메일
		// 사용자의 데이터 입력 시 공백 입력할 경우 사용자 예외 처리
		PhoneInfo info = null;
		String name = null, phoneNumber = null, addr = null, email = null;
		while (true) {
			System.out.println("이름을 입력해주세요");
			name = kb.nextLine();
			System.out.println("전화번호를 입력해주세요");
			phoneNumber = kb.nextLine();
			System.out.println("주소를 입력해주세요");
			addr = kb.nextLine();
			System.out.println("이메일을 입력해주세요");
			email = kb.nextLine();

			try {
				// 예외
				if (name.trim().isEmpty() || phoneNumber.trim().isEmpty() || addr.trim().isEmpty()
						|| email.trim().isEmpty()) {
					StringEmptyException e = new StringEmptyException();
					throw e;
				}
			} catch (StringEmptyException e) {
				System.out.println("기본정보는 공백없이 모두 입력해주셔야 합니다");
				System.out.println("다시 입력해주세요");
				continue;
			} catch (Exception e) {
				System.out.println("기본정보는 공백없이 모두 입력해주셔야 합니다");
				System.out.println("다시 입력해주세요");
				continue;
			}
			break;
		}

		switch (select) {
		case MenuNum.UNIV:
			System.out.println("전공을 입력해주세요");
			String major = kb.nextLine();
			System.out.println("학점을 입력해주세요");
			String grade = kb.nextLine();
			info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;

		case MenuNum.COMPANY:
			System.out.println("회사를 입력해주세요");
			String company = kb.nextLine();
			System.out.println("부서를 입력해주세요");
			String dept = kb.nextLine();
			System.out.println("직책을 입려해주세요");
			String job = kb.nextLine();
			// 예외
			info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;

		case MenuNum.CAFE:
			System.out.println("동호회 이름을 입력해주세요");
			String cafeName = kb.nextLine();
			System.out.println("닉네임을 입력해주세요");
			String nickName = kb.nextLine();
			// 예외
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		}
		books.add(info);
		iter=books.iterator();//추가
	}

	int searchIndex(String name) {
		int searchIndex = -1;// 해당 인덱스를 찾지 못했을 경우 기본값
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).checkName(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}

	void showInfo() {
		System.out.println("검색하실 이름을 입력해주세요");
		String name = kb.nextLine();
		int index = searchIndex(name);
		if (index < 0)
			System.out.println("검색하신 이름의 정보가 없습니다");
		else {
			System.out.println("-------------------------------------");
			books.get(index).showBasicInfo();
			System.out.println("-------------------------------------");
		}
	}

	void showAllInfo() {

		System.out.println("전체 정보를 출력합니다----------------------");

		while(iter.hasNext()) {
			iter.next().showAllInfo();
		}
		
		
	}
}
