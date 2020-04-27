package phone_book;
 
import java.util.Scanner;
 
public class PhoneBookMain {
 
    public static void main(String[] args) {
        PhoneBookManager manager = new PhoneBookManager();
        Scanner sc = new Scanner(System.in);
        int chk;// 수행할 작업 종류 판별 변수
        while (true) {
            manager.ChoiceOftheOwner();
            PhoneBookMenu.printMenu();// 메인 메뉴 출력 메서드
            chk = sc.nextInt();
//            sc.nextLine();
            switch (chk) {
            case 1://정보 저장
                manager.createInfo();
                break;
            case 2://정보 검색
                manager.searchInfo();
                break;
            case 3://정보 삭제
                manager.deleteInfo();
                break;
            case 4://모든 정보 출력
                manager.showAllData();
                break;
            case 5://작업 종료
                return;
            default:
                break;
            }
 
        }
    }
 
}