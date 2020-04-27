package abstract_and_interface;

public class PersonalNumberInfo {
	private String name;
	private String number;

	PersonalNumberInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}

	String getName() {
		return name;// 변수가 private일 경우 메서드 통해서 값 반환해야 함
	}

	String getNumber() {
		return number;
	}

}
