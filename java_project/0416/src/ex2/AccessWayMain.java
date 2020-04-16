package ex2; // 스태틱 변수의 참조

public class AccessWayMain {

	public static void main(String[] args) {
		AccessWay ac=new AccessWay();
//		System.out.println(ac.num);
		System.out.println(AccessWay.num);//스태틱 변수는 인스턴스 생성하지 않고 사용 가능
		AccessWay.num++;
		System.out.println(AccessWay.num);//스태틱 변수는 인스턴스 생성하지 않고 사용 가능
		System.out.println(ac.num2);//스태틱 변수는 인스턴스 생성하지 않고 사용 가능
		System.out.println(ac.num);//스태틱 변수는 인스턴스 생성하지 않고 사용 가능
		
	}

}
