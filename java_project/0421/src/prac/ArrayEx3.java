package prac;
//Shuffle이용 -> 로또

public class ArrayEx3 {

	public static void main(String[] args) {
		int []res=new int[6];
		res=makeLotto();
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
			
		}
	}

	public static int[] makeLotto() {
		final int COUNT = 10000;
		int tmp;
		int rand;
		int []res=new int [6];
		int []arr=new int[45];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
		for (int i = 0; i < COUNT; i++) {
				rand=(int)(Math.random()*45)+1;//1~45 랜덤 숫자
				
				tmp = arr[0];
				arr[0] = arr[rand-1];
				arr[rand-1] = tmp;
		}
		for (int i = 0; i < 6.; i++) {
			res[i]=arr[i];
		}
		
		return res;
	}
}
