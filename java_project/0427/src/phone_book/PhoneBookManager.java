package phone_book;

import java.util.Scanner;
 
/*
 상위클래스
 PhoneGeneralInfor
 하위클래스
 1.
 PhoneUnivInfor
 2.
 PhoneCompanyInfor
 3.
 PhoneClubInfor
 
 공통 인자: name, phoneNumber, email
 
 입력-> 1.일반 2.대학. 3.회사 4.동호회 ->입력
 */
 
//*제어자 사용 유의*
public class PhoneBookManager {
    private PhoneInfor[] pBooks;
    int cnt;// 인덱스 겸 입력받은 정보 개수
    Scanner sc;
    static int type;// 입력받을 정보 주체
 
    PhoneBookManager() {// 클래스 초기화 생성자
        pBooks = new PhoneInfor[100];
        cnt = 0;
        sc = new Scanner(System.in);
        type = 0;
    }
 
    // 입력받을 정보 주체 선택 메서드
    // 1.일반 2.대학. 3.회사 4.동호회
    void ChoiceOftheOwner() {
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("1.일반\n2.대학\n3.회사 \n4.동호회");
            System.out.println("------------------------------------");
            System.out.println("숫자를 입력하세요");
            System.out.println("------------------------------------");
            type = sc.nextInt();
            System.out.println("------------------------------------");
            if (type >= 0 && type <= 9) {
                switch (type) {
                case 1:
                    System.out.println("[일반 정보]");
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    System.out.println("[대학 정보]");
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    System.out.println("[회사 정보]");
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    System.out.println("[동호회 정보]");
                    System.out.println("------------------------------------");
                    break;
 
                }
                return;
            }
        }
    }
 
    PhoneInfor createInfo() {
        sc.nextLine();
        System.out.println("이름: ");
        String name = sc.nextLine();
        System.out.println("전화번호: ");
        String phoneNumber = sc.nextLine();
        System.out.println("메일: ");
        String email = sc.nextLine();
        switch (type) {
        case 1:
            pBooks[cnt] = new PhoneGeneralInfor(name, phoneNumber, email);
            System.out.println("[일반 정보를 등록완료했습니다.]");
            break;
        case 2:
            System.out.println("주소: ");
            String address = sc.nextLine();
            System.out.println("전공: ");
            String major = sc.nextLine();
            System.out.println("학년: ");
            String year = sc.nextLine();
            pBooks[cnt] = new PhoneUnivInfor(name, phoneNumber, email, address, major, year);
            System.out.println("[대학 정보를 등록완료했습니다.]");
            break;
        case 3:
            System.out.println("회사명: ");
            String company = sc.nextLine();
            pBooks[cnt] = new PhoneCompanyInfor(name, phoneNumber, email, company);
            System.out.println("[회사 정보를 등록완료했습니다.]");
            break;
        case 4:
            System.out.println("유형: ");
            String kind = sc.nextLine();
            pBooks[cnt] = new PhoneClubInfor(name, phoneNumber, email, kind);
            System.out.println("[동호회 정보를 등록완료했습니다.]");
            break;
        }
        // 하나라도 입력 안받으면 안넘어가게 만들기
        return pBooks[cnt++];// 등록된 정보 개수 증가
 
    }
 
//    void addInfor(PhoneGeneralInfor p) {// 자동 형변환하기 위해서 매개변수로 상위클래스 형태 객체 받음
//        switch (type) {
//        }
//    }
    void showAllData() {// 타입 별 모든 정보 출력
        switch (type) {
        case 1:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneGeneralInfor)
                    pBooks[i].showInfor();
            }
 
            break;
        case 2:// 대학 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneUnivInfor)
                    pBooks[i].showInfor();
            }
 
            break;
        case 3:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneCompanyInfor)
                    pBooks[i].showInfor();
            }
 
            break;
        case 4:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneClubInfor)
                    pBooks[i].showInfor();
            }
 
            break;
        }
 
//        for (int i = 0; i < cnt; i++) {
//            pBooks[i].showInfor();
//        }
    }
 
    void searchInfo() {
        sc.nextLine();
        System.out.println("검색할 이름을 입력하세요");
        String name = sc.nextLine();
        
        switch (type) {
        case 1:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneGeneralInfor) {
                    if (pBooks[i].name.equals(name))
                        pBooks[i].showInfor();
                }else {
                    System.out.println("[해당 정보가 존재하지 않습니다]");
                }
            }
 
            break;
        case 2:// 대학 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneUnivInfor) {
                    if (pBooks[i].name.equals(name))
                        pBooks[i].showInfor();
                }else {
                    System.out.println("[해당 정보가 존재하지 않습니다]");
                }
            }
 
            break;
        case 3:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneCompanyInfor) {
                    if (pBooks[i].name.equals(name))
                        pBooks[i].showInfor();
                }else {
                    System.out.println("[해당 정보가 존재하지 않습니다]");
                }
            }
 
            break;
        case 4:// 일반 정보 모두 출력
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneClubInfor) {
                    if (pBooks[i].name.equals(name))
                        pBooks[i].showInfor();
                }else {
                    System.out.println("[해당 정보가 존재하지 않습니다]");
                }
            }
 
            break;
        }
    }
    void deleteInfo() {
        sc.nextLine();
        System.out.println("삭제할 이름을 입력하세요");
        String name = sc.nextLine();
        
        switch (type) {
        case 1:// 일반 정보 
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneGeneralInfor) {
                    if (pBooks[i].name.equals(name)) {
                        for(int j=i;j<cnt;j++) {
                            pBooks[j]=pBooks[j+1];
                            cnt--;
                            System.out.println("["+name+"정보를 삭제했습니다]");
                            return;
                        }
                    }else {
                        System.out.println("["+name+" 정보가 존재하지 않습니다]");
                        break;
                    }
                }
            }
 
        case 2:// 대학 정보 
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneUnivInfor) {
                    if (pBooks[i].name.equals(name)){
                        for(int j=i;j<cnt;j++) {
                            pBooks[j]=pBooks[j+1];
                            cnt--;
                            System.out.println("["+name+"정보를 삭제했습니다]");
                            return;
                        }
                    }else {
                        System.out.println("["+name+" 정보가 존재하지 않습니다]");
                        break;
                    }
                }
            }
 
        case 3:// 회사 정보 
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneCompanyInfor) {
                    if (pBooks[i].name.equals(name)){
                        for(int j=i;j<cnt;j++) {
                            pBooks[j]=pBooks[j+1];
                            cnt--;
                            System.out.println("["+name+"정보를 삭제했습니다]");
                            return;
                        }
                    }else {
                        System.out.println("["+name+" 정보가 존재하지 않습니다]");
                        break;
                    }
                }
            }
 
        case 4:// 동호회 정보
            for (int i = 0; i < cnt; i++) {
                if (pBooks[i] instanceof PhoneClubInfor) {
                    if (pBooks[i].name.equals(name)){
                        for(int j=i;j<cnt;j++) {
                            pBooks[j]=pBooks[j+1];
                            cnt--;
                            System.out.println("["+name+"정보를 삭제했습니다]");
                            return;
                        }
                    }else {
                        System.out.println("[해당 정보가 존재하지 않습니다]");
                        break;
                    }
                }
            }
        }
    }
}
 