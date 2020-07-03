package updated_version;

import java.util.List;
import java.util.Scanner;

import examples.copy.Dept;
import examples.copy.DeptDao;

public class DEPTManager {
	DeptDao dao=new DeptDao();
	public static void deptManager() {
		Scanner sc=new Scanner(System.in);
			// 2. 데이터베이스에 접속
//			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다");

			System.out.println("----------------------------------");
			System.out.println("1.입력 2.수정 3.삭제 4.리스트 5.검색\n6.선택창으로 돌아가기 7. 종료");
			System.out.println("----------------------------------");
			int n = sc.nextInt();
			switch (n) {
			case 1:// 입력
//			insert(pstmt, conn);
				break;
			case 2:// 수정(부서이름,위치)
//			modify(pstmt, conn);
				break;
			case 3:// 삭제(사원번호)
//			delete(pstmt, conn);
				break;
			case 4:// 리스트
//			print(pstmt, conn);
				break;
			case 5:// 검색(이름)
//			search(pstmt, conn);
				break;
			case 7:
				System.exit(0);
			}


	}
	public void deptList() {
		List<Dept> deptList=dao.deptList();
		if(deptList!=null && !deptList.isEmpty()) {
			for(int i=0;i<deptList.size();i++) {
				System.out.printf("%5d",deptList.get(i).getDeptno()+"\t");
				System.out.printf("%12s",deptList.get(i).getDname()+"\t");
				System.out.printf("%12s",deptList.get(i).getLoc()+"\n");
			}
		}else {
			System.out.println("입력된 데이터가 없습니다");
		}
	}
}