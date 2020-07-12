<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String boardPw = request.getParameter("boardPw");
System.out.println("param boardPw:"+boardPw);
String boardTitle = request.getParameter("boardTitle");
System.out.println("param boardTitle:"+boardTitle);
String boardContent = request.getParameter("boardContent");
System.out.println("param boardContent:"+boardContent);
String boardUser = request.getParameter("boardUser");
System.out.println("param boardUser:"+boardUser);
 
String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
String dbUser = "temp";
String dbPw = "temp";
Connection connection = null;
PreparedStatement statement = null;
try {
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
    String sql = "INSERT INTO board(board_pw, board_title, board_content, board_user, board_date) values(?,?,?,?,now())";
    statement = connection.prepareStatement(sql);
    statement.setString(1,boardPw);
    statement.setString(2,boardTitle);
    statement.setString(3,boardContent);
    statement.setString(4,boardUser);
    statement.executeUpdate();
//  response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
} catch(Exception e) {
    e.printStackTrace();
    out.print("입력 예외 발생");
} finally {
    try {statement.close();} catch(Exception e){}
    try {connection.close();} catch(Exception e){}
}
%>
</body>
</html>


