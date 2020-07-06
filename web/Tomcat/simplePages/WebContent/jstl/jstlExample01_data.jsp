<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Member"%>
<%
	List<Member> members = new ArrayList<>();
	members.add(new Member("kim1","111@g.com"));
	members.add(new Member("kim2","111@g.com"));
	members.add(new Member("kim3",null));
	members.add(new Member("kim4","111@g.com"));
	members.add(new Member("kim5","111@g.com"));
	members.add(new Member("kim6",null));
	members.add(new Member("kim7","111@g.com"));
	application.setAttribute("members",members);
%>
데이터 생성