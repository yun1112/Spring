package prac;

public class main {

	public static void main(String[] args) {
		manager m=new manager();
		
		ex1 e1=new ex1("aaa","123");
		ex2 e2=new ex2("bbb","456","1");
		
//		e2=(ex2) e1;
		System.out.println("e2------------------------------");
		e2.showData();
//		System.out.println("e1------------------------------");
		e1=e2;
		e1.showData();
		System.out.println("------------------------------");
		
		while(true) {
//			choosingType.choose();
			menu.choose();
			m.chooseType();
			menu.mainMenu();
		}
	}

}
