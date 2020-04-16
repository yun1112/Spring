package ex;

public class Number {
	int num;
	//생성자
	Number() {//default생성자
		System.out.println("생성자 호출");
		num=1000;
	}
	Number(int n){
		System.out.println("생성자 호출");
		num=n;
	}
	public static void main(String[] args) {
//		Number n1=new Number();//인스턴스 생성
		Number n1=new Number(10000);//인스턴스 생성
//		Number n2=new Number();//인스턴스 생성
		
		System.out.println(n1.num);
	}
}
