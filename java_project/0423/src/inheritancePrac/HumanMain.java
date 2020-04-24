package inheritancePrac;

public class HumanMain {

	public static void main(String[] args) {
		Human h1=new Human();
		Human h2=new Man();
		h2.call();//Man.call();
		Man m1=new Man();
//		Man m2=(Human)h1;//작은 개념의 객체에 큰 개념의 객체 넣을 수 없음
//		Woman w1;
//		w1.call();
	}

}

class Human {
	void call() {
		System.out.println("Human call");
	}
}

class Man extends Human {
	void call() {// 오버라이딩
		System.out.println("Man");
	}

	 void status() {
		System.out.println("the status of man");
	}
}

class Woman extends Human{
	void call() {//오버라이딩
		System.out.println("Woman");
	}
	void status() {
		System.out.println("the status of woman");
	}
}