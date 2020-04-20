package Array;

public class Array04 {

	public static void main(String[] args) {
		// 정수 45개를 저장할 수 있는 배열 생성
		int[] ball = new int[45];

		// 각 배열의 요소에 1~45 숫자를 초기화
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
//			System.out.println(ball[i]);

		}
		/*
		 * for (int i = 0; i < ball.length; i++) { System.out.println(ball[i]); }
		 */

		// 배열의 요소 값의 변경을 위한 임시 변수
		int temp;

		// 랜덤한 index값: 1~44(index0은 고정되어 있으므로 index 1부터 시작)
		int j = 0;

		for (int i = 0; i < 10000; i++) {//값 shuffle
			j = (int) (Math.random() * 44) + 1;

			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}

		//숫자 6개 출력
		for (int i = 0; i < 6; i++) {
			System.out.println(ball[i]);
		}

	}

}
