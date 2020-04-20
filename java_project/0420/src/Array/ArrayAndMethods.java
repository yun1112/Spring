package Array;

public class ArrayAndMethods {

	public static void main(String[] args) {
		// 원본배열 생성
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		// 결과 저장할 배열 선언
		int[] ref;

		// 메서드 호출하고 결과를 ref에 저장
		ref = addAllArray(arr, 10);

		System.out.println("동일 배열 참조 여부 확인: " + (arr == ref));

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		for (int i = 0; i < ref.length; i++) {
			System.out.println(ref[i]);
		}

	}

	// 배열(배열 참조변수)을 전달받고, 증가시킬 정수값도 받아서
	// 모든 배열의 요소에 더해준다
	// 전달받은 배열을 다시 반환한다
	public static int[] addAllArray(int[] arr, int addVal) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] += addVal;
		}

		return arr;
	}
}
