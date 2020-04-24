package inheritancePrac;

public class CastingTest1 {

	public static void main(String[] args) {
		Car2 c=null;
		FireEngine2 fe=new FireEngine2();
		FireEngine2 fe2=null;
		
		fe.water();
		c=fe;//형변환 생략(자손->조상)
		
		fe2=(FireEngine2)c;//형 변환 명시 해야함(조상->자손)
		fe2.water();
	}

}

class Car2 {
	String color;
	int door;

	void drive() {
		System.out.println("drive");
	}

	void stop() {
		System.out.println("stop");
	}
}
class FireEngine2 extends Car2{
	void water() {
		System.out.println("water");
	}
}