package chap3;

public class ex {

	public static void main(String[] args) {
		int a = 10, b = 20;
		boolean res1, res2, check = a > b;
		res1 = a == 10 && b == 20;
		res2 = a <= 12 || b >= 30;
		System.out.println(res1);
		System.out.println(res2);

		if (!(a == b))
			System.out.println("a와 b는 같지 않다");
		else
			System.out.println("a와 b는 같다");

		if (check)
			System.out.println("a가 b보다 크다");

		else
			System.out.println("a가 b보다 크지 않다");

//		성인 여성 중 기혼자에게만 메시지를 출력합니다
		int age = 20;
		char gender = 'w';
		boolean mCheck = true;
		boolean result = age >= 20 && gender == 'w' && mCheck == true;
		if (result)
			System.out.println("성인 여성 중 기혼자입니다");
	}

}
