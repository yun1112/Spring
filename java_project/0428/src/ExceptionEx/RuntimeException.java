package ExceptionEx;

public class RuntimeException {
	public static void main(String[] args) {
		try {
			int[] arr = new int[3];
			arr[-3] = 20;// ArrayIndexOutOfBoundsException 발생
		} catch (IndexOutOfBoundsException e) {// IndexOutOfBoundsException
			System.out.println(e.getMessage());
		}

		try {
			Object obj = new int[10];
			String str = (String) obj;// ClassCastException 발생
			// instanceof로 확인해서 처리하는 방법도 있음
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}

		try {
			int[] ar = new int[-10];// NegativeArraySizeException 발생
			// 배열 생성할 때 인덱스 음수값 오류 발생시킴
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		}
		try {
			String str = null;
			int len = str.length();// NullPointerException 발생
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("무조건 실행하는 finally블록");
		}
		System.out.println("프로그램을 종료합니다");
	}
}
