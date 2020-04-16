package ex1;

public class ByteOverflow {

	public static void main(String[] args) {
		byte b = 0;
		int i = 0;// 정수형 변수 int값 범위-128~+127
		for (int x = 0; x <= 270; x++) {
			System.out.print(b++);
			System.out.print('\t');
			System.out.println(i++);
		}
	}

}
