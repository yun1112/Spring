package assignment;

import java.util.Scanner;

public class Triangle {
	// 변수: 밑변,높이
	int width;// 밑변의 데이터
	int height;// 높이의 데이터

	// 밑변과 높이 데이터를 변경하는 메서드
	void setData(int w, int h) {
		width = w;
		height = h;
	}

	// 삼각형의 넓이를 구해서 반환하는 메서드
	float area(int w, int h) {
//		return w * h / 2;
		return w * h / 2.0f;
	}

	public static void main(String[] args) {
		// 삼각형 객체 생성
		Triangle T = new Triangle();
		Scanner sc=new Scanner(System.in);
		int w=sc.nextInt();
		int h=sc.nextInt();
		// 데이터 설정
		T.setData(w,h);

		System.out.println("삼각형의 밑변: " + T.width);
		System.out.println("삼각형의 높이: " + T.height);

		// 넓이 구하는 메서드 실행
		System.out.println("삼각형의 넓이: " + T.area(w,h));

	}
}
