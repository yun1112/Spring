<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardView</title>
</head>
<body>
<h1>BOARD VIEW</h1>
<%
if(request.getParameter("boardNo") == null) {
    response.sendRedirect(request.getContextPath()+"/board/boardList.jsp");
} else {
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    System.out.println("boardNo :"+boardNo);
	String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
	String dbUser = "temp";
	String dbPw = "temp";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        String sql = "SELECT board_title, board_content, board_user, board_date FROM board WHERE board_no=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, boardNo);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
%>
            <div>board_no :</div>
            <div><%=boardNo%></div>
            <div>board_title :</div>
            <div><%=resultSet.getString("board_title")%></div>
            <div>board_content :</div>
            <div><%=resultSet.getString("board_content")%></div>
            <div>board_user :</div>
            <div><%=resultSet.getString("board_user")%></div>
            <div>board_date :</div>
            <div><%=resultSet.getString("board_date")%></div>
            <div>
                <a href="">수정</a>
                <a href="">삭제</a>
            </div>
<%
        }
    } catch(Exception e) {
        e.printStackTrace();
        out.println("BOARD VIEW ERROR!");
    } finally {
        try {resultSet.close();} catch(Exception e){}
        try {statement.close();} catch(Exception e){}
        try {connection.close();} catch(Exception e){}
    }
}
%>
</body>
</html>
Colored by Color Scripter


