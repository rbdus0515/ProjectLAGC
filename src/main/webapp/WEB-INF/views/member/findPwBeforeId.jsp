<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>

<link rel="stylesheet" href="/resources/css/member/findPassword.css"
	type="text/css">
</head>

<body>

	<c:if test="${not empty msg}">

		<script>
	
		alert('${msg}')

	</script>

	</c:if>

	<!-- 홈 로고 ---------------------------------------------------------------------------------------->
	<a href="/"> <img id="homelogo" class="logo"
		src="/resources/img/common/main/logo.png" alt="">
	</a>


	<!-- id 입력 ---------------------------------------------------------------------------------------->
	<main>

		<form action="/member/findPwAfterId" method="get" id="inputIdForm">

			<div class="content1">

				<div class="inputIdContainer">

					<img class="logo" src="/resources/img/common/main/logo.png" alt="">

					<p class="inputIdEx">비밀번호를 찾고자하는 계정의 아이디를 입력해주세요</p>


					<p>아이디</p>
					<input type="text" name="memberId" id="memberId">
					<button class="nextBtn">다음</button>


					<a href="/member/findId" id="findIdTag">아이디 찾기</a>

				</div>


			</div>

		</form>

	</main>


	<script src="/resources/js/findPw.js"></script>

</body>

</html>