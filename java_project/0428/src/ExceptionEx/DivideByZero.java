package ExceptionEx;

public class DivideByZero {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		int divide = 0;

		try {
			//예외 발생 지점
			divide = num1 / num2;
			System.out.println("연산 결과:"+divide);//연산이 될 경우에만 출력함, transaction
		} catch (Exception e) {// ArithmeticExcetpion 발생
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}finally {
			System.out.println("무조건 실행하는 finally 블록");
		}
		System.out.println("프로그램을 종료합니다");
	}
}
