package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {

	public static void main(String[] args) {
		//java.util.Date
		//cf) java.util.Calendar
		//날짜와 시간 정보를 하나로 표현
		Date today=new Date();//현재 시간
		System.out.println(today);//today.toString() 호출
		
		//모든 객체는 Object 상속
		//API클래스들은 toString 오버라이딩(재정의) 해놓음
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd. a HH:mm:ss");//a: 오전/오후 , HH: 24h 기준
		System.out.println(dateFormat.format(today) );
	}

}
