package prac;

public class ForEachMain {

	public static void main(String[] args) {
		Number[] arr = new Number[] { new Number(2), new Number(4), new Number(8) };

		System.out.println("참조변수 값 변경 전");
		for (Number e : arr)
			System.out.print(e.num + " ");
		System.out.println("");
		
		System.out.println("참조변수 값 변경 후");
		for (Number e : arr)
			e.num++;
		
		for (Number e : arr)
			System.out.print(e.getNum() + " ");
		System.out.println("");
		
		System.out.println("임시변수를 통해서 참조변수가 가리키는 값 변경 후");
		for(Number e:arr) {
			e=new Number(5);//임시 변수에 객체 생성해서 참조변수 주소값 저장
			e.num+=2;
			System.out.print(e.getNum()+" ");
		}
		System.out.println("");
		
		System.out.println("원래 배열에 저장된 값 확인");
		for(Number e:arr) {
			System.out.print(e.getNum()+" ");
		}
	}

}
