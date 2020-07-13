<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    List<Board> boardList=new ArrayList<>();
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
        String sql = "SELECT board_title, board_content, board_user, board_date FROM board";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, boardNo);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
        	Board board=new Board(resultSet.getString("boardPw"),
        			resultSet.getString("boardTitle"),
        			resultSet.getString("boardContent"),
        			resultSet.getString("boardUser"));
        	boardList.add(board);

        }
        
		request.setAttribute("boardList",boardList);
		
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
		rd.forward(request,response);
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


