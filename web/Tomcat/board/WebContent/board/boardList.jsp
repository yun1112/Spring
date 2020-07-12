<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOARD LIST</title>
</head>
<body>
	<h1>BOARD LIST</h1>
	<%
		int currentPage = 1;
	if (request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}

	int totalRowCount = 0;

	String dbUrl = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
	String dbUser = "temp";
	String dbPw = "temp";
	Connection connection = null;
	PreparedStatement totalStatement = null;
	PreparedStatement listStatement = null;
	ResultSet totalResultSet = null;
	ResultSet listResultSet = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);

		String totalSql = "SELECT COUNT(*) FROM board";
		totalStatement = connection.prepareStatement(totalSql);
		totalResultSet = totalStatement.executeQuery();
		if (totalResultSet.next()) {
			totalRowCount = totalResultSet.getInt(1);
		}
	%>
	<div>
		전체행의 수 :
		<%=totalRowCount%></div>
	<%
		int pagePerRow = 10;
	String listSql = "SELECT board_no, board_title, board_user, board_date FROM board ORDER BY board_date DESC LIMIT ?, ?";
	listStatement = connection.prepareStatement(listSql);
	listStatement.setInt(1, (currentPage - 1) * pagePerRow);
	listStatement.setInt(2, pagePerRow);
	listResultSet = listStatement.executeQuery();
	%>
	<table border="1">
		<thead>
			<tr>
				<th>boardTitle</th>
				<th>boardUser</th>
				<th>boardDate</th>
			</tr>
		</thead>
		<tbody>
			<%
				while (listResultSet.next()) {
			%>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/board/boardView.jsp?boardNo=<%=listResultSet.getInt("board_no")%>">
						<%=listResultSet.getString("board_title")%>
				</a></td>
				<td><%=listResultSet.getString("board_user")%></td>
				<td><%=listResultSet.getString("board_date")%></td>
			</tr>


			<%
				}
			%>
		</tbody>
	</table>
	<div>
		<a href="<%=request.getContextPath()%>/board/boardAddForm.jsp">게시글
			입력</a>
	</div>
	<%
		int lastPage = totalRowCount / pagePerRow;
	if (totalRowCount % pagePerRow != 0) {
		lastPage++;
	}
	%>
	<div>
		<%
			if (currentPage > 1) {
		%>
		<a
			href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage - 1%>">이전</a>
		<%
			}
		if (currentPage < lastPage) {
		%>

		<a
			href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage + 1%>">다음</a>
		<%
			}
		%>
	</div>
	<%
		} catch (Exception e) {
	e.printStackTrace();
	out.print("데이터 가져오기 에러!");
	} finally {
	try {
		totalResultSet.close();
	} catch (Exception e) {
	}
	try {
		listResultSet.close();
	} catch (Exception e) {
	}
	try {
		totalStatement.close();
	} catch (Exception e) {
	}
	try {
		listStatement.close();
	} catch (Exception e) {
	}
	try {
		connection.close();
	} catch (Exception e) {
	}
	}
	%>
</body>
</html>


