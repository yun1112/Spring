package ex;

public class Card {
	static int width = 100;
	static int height = 250;

	String kind;
	int number;

	Card() {// default 생성자

	}

	Card(String type, int num) {// 생성자 오버로딩
		kind = type;
		number = num;
	}
}
