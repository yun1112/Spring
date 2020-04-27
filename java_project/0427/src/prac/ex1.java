package prac;

public class ex1 {
	private String name;
	private String id;

	ex1(String name, String id) {
		this.name = name;
		this.id = id;
	}

	void showData() {
		System.out.println("name:"+this.name+",id:"+this.id);
	}

	@Override
	public String toString() {
		return "ex1 [name=" + name + ", id=" + id + "]";
	}

}

class ex2 extends ex1 {
	private String age;

	public ex2(String name, String id, String age) {
		super(name, id);
		this.age = age;
	}

	void showData() {
		super.showData();
		System.out.println("age:"+this.age);
	}

	@Override
	public String toString() {
		return "ex2 [age=" + age + "]";
	}
//자동 형변환
}
