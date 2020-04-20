package Array;

public class AddArrayMain {

	public static void main(String[] args) {
//		int []arr=new int[100];
		int[][]arr2=new int[10][10];
		/*일차원 배열의 모든 값 초기화
		 * for (int i = 0; i < arr.length; i++) { arr[i]=i+1; }
		 */
		
//		addOneDArr(arr, 10);//일차원 배열에서 정상동작함
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		
		
		for (int i = 0; i < 10; i++) {//2차원 배열 arr2 값 초기화
			for (int j = 0; j < 10; j++) {
				arr2[i][j]=i*10+j+1;
				System.out.println("arr2:"+arr2[i][j]);
			}
		}

		System.out.println("------두번째 메서드 호출 후 이차원 배열에 저장된 값 출력-------");
		addOneDarr(arr2,10);//이차원 배열 arr2에 저장된 모든 값 10만큼 증가시키는 메서드 호출
		for (int i = 0; i <arr2.length; i++) {//2차원 배열 arr2 값 초기화
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.println("arr2:"+arr2[i][j]);
			}
		}
	}
	/* 일차원 배열에 저장된 모든 값 add만큼 증가시키는 메서드
	 * public static void addOneDArr(int[] arr, int add) { for (int i = 0; i <
	 * arr.length; i++) { arr[i]+=add; }
	 */

	
	public static void addOneDarr(int[][] arr,int add) {//이차원 배열의 모든 값 add만큼 증가시키는 메서드
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]+=add;
			}
			/*
			 * for (int j = 0; j < arr.length; j++) { }
			 */
		}
	}
}
