<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsTestProc1.jsp</title>
</head>
<body>
	<h3>* 파일 첨부 테스트 결과 *</h3>
	<%
		//한글이 깨지지 않게 request.setCharacterEncoding("UTF-8"); //pdsTest1.jsp 에서 담고 있는 것들 가져오기 /* out.println(request.getParameter("uname")); out.println("<hr>"); out.println(request.getParameter("subject")); out.println("<hr>"); out.println(request.getParameter("title")); out.println("<hr>"); out.println(request.getParameter("filenm")); out.println("<hr>"); //--------------------------------------------------------------------------------------------------------------------------------- - <form>에 enctype 속성이 추가 되면 request객체가 가지고 있는 값을 제대로 가져올 수 없기 때문에 - request.getParameter() 는 null이 반환된다. */ try{ //실제 물리적 경로 String saveDirectory=application.getRealPath("/storage"); //저장 최대 용량 (10M) - 각자 알아서 저장무게를 정하되 너무 무겁지 않도록 int maxPostSize= 1024*1024*10; //한글 조합 String encoding="UTF-8"; //사용자가 전송한 텍스트 정보 및 파일을 '/storage'에 저장하기 (MultipartRequest의 매개변수에 맞춰서 위에서 지정한 변수를 넣어준 것) MultipartRequest mr=new MultipartRequest(request, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy()); out.print("<p>파일 전송 저장 성공!</p>"); //1) mr참조변수가 가리키고 있는 텍스트 정보 가져오기 out.print(mr.getParameter("uname")); out.print("<hr>"); out.print(mr.getParameter("subject")); out.print("<hr>"); out.print(mr.getParameter("content")); out.print("<hr>"); //2) storage 폴더에 저장된 파일 정보 확인하기 // 사용자가 전송시킨 것을 mr에서 담음. mr에서 <input type=file>을 ★전부★ 가져온다 Enumeration files=mr.getFileNames(); //★3) 2)의 files가 가지고 있는 값에서 개별 접근 //첨부 파일이 여러 개일 수도 있기 때문에 그것을 각자 ★개별★ 접근 //첨부 파일이 있는 첨부의 name="filenm" String item=(String) files.nextElement(); out.print(item); //filenm out.print("<hr>"); //4) 3)에서 item이름으로 전송된 실제 파일을 mr객체에서 가져오기 String ofileName=mr.getOriginalFileName(item); String fileName=mr.getFilesystemName(item); out.print("원본 파일명 : "+ofileName); out.print("<hr>"); out.print("리네임 파일명 : "+fileName); out.print("<hr>"); //5) 저장된 파일의 기타 세부 정보 확인하기 (basicJava/src/oop0611/Test02_File.java) File file=mr.getFile(item); if(file.exists()){ //파일이 존재하는지 out.print("파일명 : "+file.getName()); out.print("<hr>"); out.print("파일크기 : "+file.length()); out.print("<hr>"); }else{ out.print("해당 파일이 존재하지 않음."); }//if end //6) 저장된 파일 다운로드 // 단, 웹브라우저에서 해석되는 페이지는 제외 // .html .jsp .asp .php .png .jpg .gif .avi .mp3 out.print("첨부파일 : "); out.print("<a href='../storage/" + file.getName()+ "'>"); out.print(file.getName()); // 브라우저에서 해석이 안되는 것은 링크가 나타남 out.print("</a>"); }catch(Exception e){ out.print(e); out.print("<p>파일 업로드 실패 T.T </p>"); out.print("<a href='javascript:history.back();'[다시시도]</a>"); }//try end
	%>
</body>
</html>

