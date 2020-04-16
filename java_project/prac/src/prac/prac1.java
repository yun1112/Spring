package prac;

import java.util.Scanner;

public class prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {// hasNext(): 입력된 값, 토큰이 있으면 true 리턴
			System.out.println(sc.nextLine());// \n를 포함한 라인을 읽어 값을 내보냄
		}
	}
}

//Iterator

// public boolean hasNext(); //  다음 요소가 있는 지 판별
// public Object next(); //다음으로 이동하는 next 메서드
// public void remove(); // 읽어 온 요소를 삭제하는 remove 메서드

/*
 * iterator 개체는 컬렋ㄴ 개체의 iterator 메서드를 호출하여 얻어올 수 있음 그리고 hasNext메서드로 이동이 가능한지 확인한
 * 후에 next메서드로 해당 위치에 보관한 개체를 참조하여 원하는 작업 수행
 */
