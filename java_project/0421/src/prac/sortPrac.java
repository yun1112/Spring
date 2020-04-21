package prac;

public class sortPrac {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i * (arr.length) + j;
//				System.out.print(arr[i][j]+" ");
			}
//			System.out.println("");
		}
		System.out.println("----------------------------------------------------");
		System.out.println("원본 배열");
		PrintArr(arr);
		System.out.println("----------------------------------------------------");
		System.out.println("셔플 후 배열");
		for (int i = 0; i < arr.length; i++) {
			ShuffleArr(arr[i]);
		}
		PrintArr(arr);
		
		System.out.println("----------------------------------------------------");
		System.out.println("버블 정렬 후 배열");
		for (int j = 0; j < arr.length; j++) {
			BubbleSort(arr[j]);
		}
		PrintArr(arr);
		System.out.println("----------------------------------------------------");

	}

	public static void PrintArr(int[][] arr) {// 2차원 배열 출력 메서드
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void ShuffleArr(int[] arr) {// Shuffle 메서드
		final int COUNT = 10000;
		int tmp = arr[0];
		for (int i = 0; i < COUNT; i++) {// 만 번 shuffle 반복
			for (int j = 1; j < arr.length; j++) {
				arr[0] = arr[j];
				arr[j] = tmp;
				tmp = arr[0];
			}
		}
	}

	public static void SelectionSort(int[] arr) {// 선택 정렬 메서드
		int tmp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void BubbleSort(int[] arr) {// 버블 정렬 메서드
		int tmp = arr[0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}
