package prac;

public class lottoPrac {

	public static void main(String[] args) {
		int []res=new int[6];
		res=makeLotto();
		printAll(res);
	}

	public static int[] makeLotto() {
		int[] res = new int[6];
		int[] arr=new int[45];
		final int COUNT = 10000;
		int rand;
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
		for (int i = 0; i < COUNT; i++) {
			rand = (int) (Math.random() * 45);// 0~44
			tmp = arr[0];
			arr[0] = arr[rand];
			arr[rand] = tmp;
		}
		for (int i = 0; i < 6; i++) {
			res[i]=arr[i];
		}
		return res;
	}
	
	public static void printAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
