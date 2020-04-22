package ver01;



import java.util.Scanner;


public class ee {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int num;
  int index = 0;

  String str = new String();
  PhoneInfor[] info = new PhoneInfor[100];

  System.out.println("---------------------------------------------------------");
  System.out.println("전화번호 관리 프로그램 ver 0.30");
  System.out.println("---------------------------------------------------------");
//  System.out.println("---------------------------------------------------------");

  while (true) {
//   System.out.println("---------------------------------------------------------");
   System.out.println("원하는 작업을 선택하세요");
   System.out.println("-------------------------------------------------------");
   System.out.println("1. 저장 2. 검색 3. 삭제");
   System.out.println("-------------------------------------------------------");
   num = sc.nextInt();
   // if(num!=1) index-=1;//
   switch (num) {
   case 1:
    System.out.println("-------------------------------------------------------");
    System.out.println("이름, 전화번호, 생년월일 입력");

    String name = sc.next();
    String phoneNumber = sc.next();
    String birthday = sc.next();

    info[index] = new PhoneInfor();
    // 배열 생성
    info[index].name = name;
    info[index].phoneNumber = phoneNumber;
    info[index].birthday = birthday;

    index++;
    break;
   case 2:
    System.out.println("검색할 이름 입력");
    str = sc.next();
    
    for (int i = 0; i < index; i++) {
     info[i].searchInfo(str);
    }
    break;
   case 3:
    System.out.println("삭제할 이름 입력");
    str = sc.next();

    for (int i = 0; i < index; i++) {
     info[i].deleteInfo(info,str);
     index--;
//     info[i]=null;
    }
    break;
   default:
    break;
   }
   System.out.println("---------------------------------------------------------");

  }

//    p2.printAl();

 }

 static class PhoneInfor {
  String name;
  String phoneNumber;
  String birthday;

  PhoneInfor() {

  }

  PhoneInfor(String n, String p) {//생년월일 제외 초기화 생성자 메서드
   name = n;
   phoneNumber = p;
  }

  PhoneInfor(String n, String p, String b) {
   name = n;
   phoneNumber = p;
   birthday = b;
  }

  @Override
  public String toString() {// toString()메서드 오버라이딩
   return "PhoneInfor [name=" + name + ", phoneNumber=" + phoneNumber + ", birthday=" + birthday + "]";
  }

  // 입력된 정보 출력 메서드
  public void printAl() {
   System.out.println("-------------------------------------------------------");
   System.out.println("이름: " + this.name);
   System.out.println("전화번호: " + this.phoneNumber);
//    if (birthday.equals("") == false)
   System.out.println("생년월일: " + this.birthday);
   System.out.println("-------------------------------------------------------");
  }

  // 정보 검색 메서드
  public void searchInfo(String str) {

   // 여기 수정
   if (this.name.equals(str) == true) {
    System.out.println("-------------------------------------------------------");
    System.out.println("이름: " + this.name);
    System.out.println("전화번호: " + this.phoneNumber);
//      if (birthday.equals("") == false)
    System.out.println("생년월일: " + this.birthday);
    System.out.println("-------------------------------------------------------");
   }
  }

  public void deleteInfo(PhoneInfor[] p, String str) {

   PhoneInfor tmp;
   tmp = p[0];
   for (int i = 0; i < p.length; i++) {//해당 참조변수가 있던 자리부터 한칸씩 당김
    if (this.name.equals(str) == true) {
     for (int j = i; j < p.length - 1; j++) {
      p[i] = p[i + 1];
     }
    }
   }
   p[p.length - 1] = null;//마지막 참조변수 제거
   
  }

 }
}