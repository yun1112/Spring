package prac;

import java.util.Arrays;
import java.util.Scanner;

public class PhoneBookManager3 {
	PhoneInfor3[] pBooks;
	int cnt;
	Scanner sc = new Scanner(System.in);

	PhoneBookManager3() {
		cnt = 0;
		pBooks = new PhoneInfor3[100];
	}

	void saveData() {
		System.out.println("이름 입력>>");
		String name = sc.nextLine();
		System.out.println("전화번호 입력>>");
		String phoneNumber = sc.nextLine();
		System.out.println("생일 입력>>");
		String birthday = sc.nextLine();

		if (birthday == null || birthday.trim().isEmpty()) {// 메서드에 전달하는 인자 2개인 생성자 호출
			pBooks[cnt++] = new PhoneInfor3(name, phoneNumber);
			pBooks[cnt].showInfor();
		} else {// 메서드에 전달하는 인자 3개인 생성자 호출
			pBooks[cnt++] = new PhoneInfor3(name, phoneNumber, birthday);
		}
		
		for (int i = 0; i < cnt; i++) {
			System.out.println("저장 확인");
			System.out.println(pBooks[i]);//toString()
		}
	}
	

	int  searchData() {
		System.out.println("찾을 이름 입력");
		String name=sc.nextLine();
		int searchIndex=-1;
		
		for (int i = 0; i < cnt; i++) {
			if(pBooks[i].equals(name)) {//해당 이름이 존재할 경우
				pBooks[i].showInfor();//관련된 정보 출력
				searchIndex++;
			}
			
		}
		
		return searchIndex;
	}
	
	void deleteData() {
		System.out.println("삭제할 이름 입력");
		String name=sc.nextLine();
		int searchIndex=-1;
		
		for (int i = 0; i < cnt; i++) {
			if(pBooks[i].equals(name)) {
				searchIndex++;
			}
		}
		
		for (int i = searchIndex; i < cnt; i++) {
			if(pBooks[i].checkName(name)) {//cnt 감소시키고 인스턴스 배열 한칸씩 당김
					pBooks[i]=pBooks[i+1];
			}
		}
		
		pBooks[cnt-1]=null;//참조 변수 메모리 해제
		cnt--;
	}
	
	void showAllData() {
		for (int i = 0; i < cnt; i++) {
			System.out.printf("이름:%s\n전화번호:%s\n생일:%s\n",pBooks[i].getName());

		}
	}

}
