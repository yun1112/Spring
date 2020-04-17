package assignment;//생성자 사용 버전

public class Boy2 {

	// 구슬의 개수
	int numOfMarble;

	Boy2(){
		
	}
	
	Boy2(int num){
		numOfMarble=num;
	}
	

	
	// 구슬의 개수 설정
	void setMarble(int num) {
		numOfMarble = num;
	}

	void gameWin(Boy2 boy, int num) {
		numOfMarble += num;
		boy.numOfMarble -= num;
	}
	
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 "+numOfMarble+"개 입니다");
	}
	
	public static void main(String[] args) {
		
		//철수 생성 
		Boy2 b1=new Boy2(15);
		//영희 생성
		Boy2 b2=new Boy2(9);
		
		
//		//철수는 구슬을 15개 보유
//		b1.setMarble(15);
//		//영희는 구슬을 9개 보유
//		b2.setMarble(9);
		
		System.out.println("철수는 구슬을 "+b1.numOfMarble+"개 보유중");
		System.out.println("영희는 구슬을 "+b2.numOfMarble+"개 보유중");
		System.out.println("--------------------------------------------------------------------------");
		
		//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
		System.out.println("1차 게임에서 철수는 영희의 구슬 2개를 획득한다");
		b1.gameWin(b2,2);
		
		System.out.println("철수");
		b1.showData();
		System.out.println("영희");
		b2.showData();
		
		System.out.println("--------------------------------------------------------------------------");
		
		//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
		System.out.println("2차 게임에서 영희는 철수의 구슬 7개를 획득한다");
		b2.gameWin(b1,7);
		System.out.println("철수");
		b1.showData();
		System.out.println("영희");
		b2.showData();
		
		System.out.println("--------------------------------------------------------------------------");
		
	}
}
