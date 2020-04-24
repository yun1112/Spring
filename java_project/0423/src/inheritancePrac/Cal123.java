package inheritancePrac;

abstract class Calculator {// 추상 클래스(객체 생성 불가)
	int n1, n2;

	public void setNum(int n1, int n2) {// 피연산자 값 설정 메서드
		this.n1 = n1;
		this.n2 = n2;
	}

	public abstract void CalResult();

}

class Sum extends Calculator {
	public void CalResult() {//메서드 오버라이딩
		System.out.println("결과:" + (this.n1 + this.n2));
	}
}

class Subtractor extends Calculator {
	public void CalResult() {
		System.out.println("결과:" + (this.n1 - this.n2));
	}
}

public class Cal123 {
	public static void main(String[] args) {
		//일반적인 계산기
//		Sum sum=new Sum();
//		sum.setNum(10, 20);
//		sum.CalResult();
//		
//		Subtractor sub=new Subtractor();
//		sub.setNum(20, 10);
//		sub.CalResult();
		
		//다형성 개념 이용
		Calculator c1=new Sum();
		Calculator c2=new Subtractor();
		
		exe(c1);
		exe(c2);
		
	}
	public static void exe(Calculator cal) {
		cal.setNum(10, 20);
		cal.CalResult();
	}
}