package Array;

public class changeArr {

	public static void main(String[] args) {
		int arr[][]=new int [10][10];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=i*10+j;
			}
		}
		cngArr(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void cngArr(int arr[][]) {{// 한 행씩 아래 방향으로 밀리는 형식의 배열 만드는 메서드

		//배열의 참조변수 성질 이용
		//참조변수가 저장하고 있는 주소값을 변경하는 메서드
		int tmp[];
		int tmp2[];
		//tmp=arr[arr.length-1];
		tmp2=arr[0];
		for (int i = 1; i < arr.length-1; i++) {//0 1 2~ N-1 -> N-1 0 1 2~ N-2
			arr[i]=arr[i%(arr.length-1)];
			arr[i]=arr[i+1];
		}
		//arr[0]=tmp;
		//arr[arr.length-1]=tmp2;
		

	}
	}
}
