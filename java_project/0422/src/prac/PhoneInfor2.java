package prac;

public class PhoneInfor2 {
	private String name;
	private String phoneNumber;
	private String birthday;
	
	PhoneInfor2(){}
	
	PhoneInfor2(String name, String phoneNumber,String birthday){
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.birthday=birthday;
	}
	PhoneInfor2(String name, String phoneNumber){
		this(name,phoneNumber,"생일이 입력되지 않았습니다");
	}
	
	void printAll() {
		System.out.printf("이름: %s\n전화번호:%s\n생일:%s\n",this.name,this.phoneNumber,this.birthday);
	}
}
