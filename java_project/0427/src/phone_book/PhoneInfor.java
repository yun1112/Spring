package phone_book;

 
/*
상위클래스
PhoneGeneralInfor
String name
String phoneNumber
String email
하위클래스
1.
PhoneUnivInfor
String name
String phoneNumber
String email
String address
String major
String year
2.
PhoneCompanyInfor
String name
String phoneNumber
String email
String company
3.
PhoneClubInfor
String name
String phoneNumber
String email
String kind
공통 인자: name, phoneNumber, email
입력-> 1.일반 2.대학. 3.회사 4.동호회 ->입력
*/
public class PhoneInfor {
    String name;
    String phoneNumber;
    String email;
 
    PhoneInfor(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
 
    void showInfor() {// 하위 클래스에서 오버라이딩 해서 사용할 메서드
        System.out.println("이름: " + this.name);
        System.out.println("전화번호: " + this.phoneNumber);
        System.out.println("메일: " + this.email);
    }
    
}
 
class PhoneGeneralInfor extends PhoneInfor {
    String name;
    String phoneNumber;
    String email;
 
    PhoneGeneralInfor(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
 
    }
 
    void showInfor() {
        System.out.println("------------------------------------");
        System.out.println("[일반 정보]");
        super.showInfor();
        System.out.println("------------------------------------");
    }
}
 
class PhoneUnivInfor extends PhoneInfor {
    String name;
    String phoneNumber;
    String email;
 
    String address;
    String major;
    String year;
 
    public PhoneUnivInfor(String name, String phoneNumber, String email, String address, String major, String year) {
        super(name, phoneNumber, email);
        this.address = address;
        this.major = major;
        this.year = year;
    }
 
    void showInfor() {
        System.out.println("------------------------------------");
        System.out.println("[대학 정보]");        
        super.showInfor();
        System.out.println("주소: " + this.address);
        System.out.println("전공: " + this.major);
        System.out.println("학년: " + this.year);
        System.out.println("------------------------------------");
    }
}
 
class PhoneCompanyInfor extends PhoneInfor {
    String name;
    String phoneNumber;
    String email;
 
    String company;
 
    public PhoneCompanyInfor(String name, String phoneNumber, String email, String company) {
        super(name, phoneNumber, email);
        this.company = company;
    }
 
    void showInfor() {
        System.out.println("------------------------------------");
        System.out.println("[회사 정보]");        
        super.showInfor();
        System.out.println("회사" + this.company);
        System.out.println("------------------------------------");
 
    }
}
 
class PhoneClubInfor extends PhoneInfor {
    String name;
    String phoneNumber;
    String email;
 
    String kind;
 
    public PhoneClubInfor(String name, String phoneNumber, String email, String kind) {
        super(name, phoneNumber, email);
        this.kind = kind;
    }
 
    void showInfor() {
        System.out.println("------------------------------------");
        System.out.println("[동호회 정보]");
        super.showInfor();
        System.out.println("종류: " + this.kind);
        System.out.println("------------------------------------");
    }
}
 