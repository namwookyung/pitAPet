<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="./css/basic.css" />
	<link rel="stylesheet" href="./css/prod_view.css" />
	<script src="./js/jquery.js"></script>
	<script src="./js/jquery.bxslider.min.js"></script>
	<script src="./js/isotope.pkgd.min.js"></script>
	<script src="./js/common.js"></script>
	<script src="./js/main.js"></script>

    <title>PIT-A-PET</title>
  </head>
  <body>
<!-- 로그인바 -->
	<nav class="navbar navbar-expand-sm navbar-light" id="login-bar">
		<a class="navbar-brand" id="navyellow" href="main.jsp">PIT-A-PET</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
<%
	if(id == null) {
%>
					<a class="nav-link active" id="navyellow" href="./userLogin.do">로그인</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="./userJoin.do">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="cart.jsp">장바구니</a>
				</li>

<%}	else {%>
<% if(id.equals("admin")) {%>
				<li>
					<a class="nav-link" id="navyellow" href="admin.jsp">관리자 메인</a>
				</li>
<%} %>
				<li>
					<a class="nav-link" id="navyellow" href="./userLogout.do">로그아웃</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="navyellow" href="cart.jsp">장바구니</a>
<%
	}
%>
				</li>
			</ul>
		</div>
	</nav>

<!-- 로고 -->
	<div class="logo">
	<a href="main.jsp"><img src="./img/LOGO.png"></a>
	</div>

<!-- 메뉴바 -->
	<div id="header-wrap">
		<header class="header-inner">
			<nav id="gnb">
				<ul>
					<li class="m1"><a href="intro.jsp">사이트 소개</a></li>
					<li class="m2"><a href="view_all.jsp">전체 보기</a></li>
					<li class="m3"><a href="#">강아지</a>
						<ul>
							<li><a href="for_dog1.jsp">용품</a></li>
							<li><a href="for_dog2.jsp">간식</a></li>
							<li><a href="for_dog3.jsp">장난감</a></li>
						</ul></li>
					<li class="m4"><a href="#">고양이</a>
						<ul>
							<li><a href="for_cat1.jsp">용품</a></li>
							<li><a href="for_cat2.jsp">간식</a></li>
							<li><a href="for_cat3.jsp">장난감</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>
	</div>
	
<!-- 상세 정보 -->
	<section>
	<div id="fdiv">
		<div class="sdiv">
			<img src="./img/for_cat/cashacasha_01.jpg" class="img">
		</div>
		<div class="sdiv">
			<form>
				<table>
					<tr>
						<td class="left">이름　 |　 카샤카샤</td>		<!-- 함수 넣고 -->
					</tr>
					<tr>
						<td class="left">가격　 |　 5,000원</td>		<!-- 함수 넣고 -->
					</tr>
					<tr>
						<td class="left">상품　 |　 
							<select>
								<option>카샤카샤-1</option>		<!-- 함수 넣고 -->
								<option>카샤카샤-2</option>		<!-- 함수 넣고 -->
								<option>카샤카샤-3</option>		<!-- 함수 넣고 -->
								<option>카샤카샤-4</option>		<!-- 함수 넣고 -->
								<option>카샤카샤-5</option>		<!-- 함수 넣고 -->
								<option>카샤카샤-6</option>		<!-- 함수 넣고 -->
							</select>
						</td>
					</tr>
					<tr>
						<td class="left">수량　 |　 <!-- 함수 넣고 -->1</td>
					</tr>
					<tr>
						<td class="td5">총 금액　 |　 <!-- 함수 넣고 -->5,000원</td>
					</tr>
					<tr>
						<td class="td6">
							<button type="submit" class="btn form-control" id="btn">장바구니 담기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	
	<!-- 상세 정보 출력 -->
		<div id ="center">
			<h4>상품 상세 설명</h4>
				<img src = "./img/for_cat/cashacasha_06.jpg" class="img2">
				<img src = "./img/for_cat/cashacasha_06.jpg" class="img2">
				<img src = "./img/for_cat/cashacasha_06.jpg" class="img2">
				<img src = "./img/for_cat/cashacasha_06.jpg" class="img2">
				<img src = "./img/for_cat/cashacasha_06.jpg" class="img2">
				
			<!-- 함수 넣어서 내용 출력 -->
			
		</div>
	</section>
	
	
	
<!-- 푸터 -->
	<div class="fdiv">
		<footer>
			<div>
				<a href="main.jsp"><img src="./img/LOGO.png"></a>
			</div>
			<div class="fdiv2">
				이용약관 | 개인정보처리방침<br>
				상호 : PIT-A-PET | 주소 : 대구광역시 달서구 달구벌대로 251 안길 15(이곡동 1224-2번지) <br>
				대표 번호 : 053-123-4567 | 팩스 번호 : 053-123-4568<br>
				COPYRIGHT (c) pitapet.com ALL RIGHTS RESERVED. DESIGNED BY TURU.
			</div>
			<div class="fdiv2">
				고객센터 053-123-4567<br>
				평일 10:00 ~ 18:00<br>
				점심시간 13:00 ~ 14:00<br>
				메일 gangrg@pitapet.com
			</div>
		</footer>
	</div>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
  </body>
</html>