package ver01;

public class PhonebookMain {

	public static void main(String[] args) {
		PhoneInfor info=new PhoneInfor("손흥민", "000-9999-98888", "2000.11.11");
		info.showInfor();
		
		System.out.println("-----------------------------------------------------------------");
		info=new PhoneInfor("박지성", "000-7777-5555");
		info.showInfor();
	}

}
