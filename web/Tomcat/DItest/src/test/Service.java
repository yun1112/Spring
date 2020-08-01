package test;

public class Service {
	// Service클래스는 Dao클래스에 의존한다
	// Dao dao=new Dao();
	Dao dao;

	// 의존성 낮춤
	public void setDao(Dao dao) {
		this.dao = dao;// Dao타입의 인터페이스로 인스턴스 생성 가능
	}

	public void print() {
		dao.print();
	}

}
