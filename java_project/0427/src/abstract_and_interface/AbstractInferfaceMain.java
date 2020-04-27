package abstract_and_interface;

public class AbstractInferfaceMain {

	public static void main(String[] args) {
//		PersonalNumberStroage storage = new PersonalNumberStorageImpl(100);//extends, 추상클래스
		PersonalNumber  pn=new PersonalNumberStorageImpl(100);//implements, 인터페이스
		
		pn.addPersonalInfo("202020-111111111", "손흥민");
		pn.addPersonalInfo("202020-22222", "박지성");
		
		System.out.println(pn.searchName("202020-111111111"));
		
//		storage.addPersonalInfo("202020-111111111", "손흥민");
//		storage.addPersonalInfo("202020-22222", "박지성");
//		
//		System.out.println(storage.searchName("202020-111111111"));
	}

}
