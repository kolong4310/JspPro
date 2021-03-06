<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop</title>
<link href="css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="mypage/mypage.js"></script>
</head>

<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="NonageServlet?command=index">
				<img src="images/grocery/4_Grayscale_logo_on_transparent_119x73.png" width="180" height="100" alt="main_logo">
				</a>
			</div>
			
			<nav id="catagory_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}"> <!--로그인 담당하는 부분 비어 있으면. 로그인 안되어 있으면  -->
							<li>
								<a href="NonageServlet?command=login_form">로그인</a>
							</li>
							<li>/</li>
							<li><a href="NonageServlet?command=contract">회원가입</a></li>
						</c:when>
						
						<c:otherwise>
							<li style="color:orange">
								${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
							</li>
							
							<li><a href="NonageServlet?command=logout">로그아웃</a></li>
							<li><a href="NonageServlet?command=cart_list">장바구니</a></li>
						</c:otherwise>
					</c:choose>
					
						<li>/</li>
						<li>
							<a href="NonageServlet?command=mypage">내정보</a>
						</li><li>/</li>
						<li>
							<a href="NonageServlet?command=qna_list">Q&amp:A(1:1)</a>
						</li>
						<li>
							<a href="NonageServlet?command=admin_login_form"> 관리자</a>
						</li>
					</ul>
				</nav>
				
				<nav id="top_menu">
					<ul>
						<li>
							<a href="NonageServlet?command=catagory&kind=1">냉동식품</a>
						</li>
						
						<li>
							<a href="NonageServlet?command=catagory&kind=2">야채</a>
						</li>
						
						<li>
							<a href="NonageServlet?command=catagory&kind=3">축산</a>
						</li>
						
						<li>
							<a href="NonageServlet?command=catagory&kind=4">수산</a>
						</li>
						
						<li>
							<a href="NonageServlet?command=catagory&kind=5">과일</a>
						</li>
						
						<li>
							<a href="NonageServlet?command=catagory&kind=6">할인상품</a>
						</li>
					</ul>
				</nav>
				
				<div class="clear"></div>
				<hr>
				
		</header>
	</div>
</body>
</html>