package ex;

public class howMany {
	int asset ;// 소유하고 있는 구슬 개수

	public void setHowmany(int asset) {
		this.asset=asset;
	}
	
	public int getHowmany() {
//		System.out.println("현재 보유 구슬 개수:"+asset);
		return asset;
	}
//	public static int leftover(int num, boolean result) {// 플레이 후 남아있는 구슬의 수를 반환하는 메서드
//		int left=asset;//현재 소유하고 있는 구슬 개수
//		if (result == true)//이겼으면 구슬 수 증가시킴
//			left = asset + num;
//		else if(result==false)//졌으면 구슬 수 감소시킴
//			left = asset - num;
//
//		return left;
//	}
	
	public  void  leftover(howMany h,int num) {// 플레이 후 남아있는 구슬의 수를 반환하는 메서드
		int left;//현재 소유하고 있는 구슬 개수

		left=h.getHowmany()-num;//다른 인스턴스의 구슬 수 감소시킴
//		System.out.println("다른 객체의 현재 구슬 개수:"+left);
		
		h.setHowmany(left);
//		System.out.println("다른 객체의 현재 구슬 개수  확인:"+h.getHowmany());
		
		
		asset+=num;
		
//		System.out.println("현재 객체의 구슬 개수 확인:"+asset);
//		return asset;
	}
}
