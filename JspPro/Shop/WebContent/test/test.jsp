<%@page import="com.nonage.dao.ProductDAO"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDAO dbCon=ProductDAO.getInstance();
	Connection con=dbCon.getConnection();
	if(con!=null){
		out.println("연결 성공");
	}

%>