package Univ_using_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ManageMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException {

		// 0. 드라이버 LIB 추가
		// 1. 데이터베이스 드라이버 로드
		// Class.forName(드라이버 클래스 전체이름)
		// Oracle : oracle.jdbc.driver.OracleDriver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("데이터베이스 드라이버 로드 완료...!!");

		UnivManager univManager = new UnivManager();

		while (true) {
			System.out.println("Select Menu");
			System.out.println("----------------------------------");
			System.out.println("1. university  2. company 3. club");
			System.out.println("----------------------------------");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				univManager.univManager();
				// empManager();
				break;
			case 2:
				univManager.univManager();
				break;
			case 3:
				break;
			default:
				System.out.println("올바른 입력이 아닙니다\n다시 입력해주세요");
				break;
			}

		}

	}

}