package chap3;

public class prac2 {

	public static void main(String[] args) {
		int numOfApples=123, sizeOfBucket=10,numOfBucket=numOfApples/sizeOfBucket;
//		
//		if(sizeOfBucket%numOfApples>0)
//			numOfBucket++;
		
		numOfBucket=(sizeOfBucket%numOfApples>0) ? numOfBucket+1 :numOfApples/sizeOfBucket;
		System.out.println("필요한 바구니의 수: "+numOfBucket);
		
	}

}
