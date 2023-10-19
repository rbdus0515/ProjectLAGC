<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>

    <link rel="stylesheet" href="/resources/css/member/login.css" type="text/css">
</head>

<body>

	<c:if test="${not empty msg}">

	<script>
	
		alert('${msg}')

	</script>

	</c:if>

<!-- 홈 로고 ---------------------------------------------------------------------------------------->
    <a href="/">
        <img id="homelogo" class="logo" src="/resources/img/common/main/로고.png" alt="">
    </a>

<!-- 메인 ---------------------------------------------------------------------------------------->
    <main class="mainContainer">

        <form action="login" method="post" id="loginFrm" >
 
            <div class="loginContainer">
                <section>
                    <img class="logo" src="/resources/img/common/main/로고.png" alt="">
                </section>

                <section class="id">
                    <p>아이디</p>
                    <input class="input" type="text" name="memberId" id="memberId">
                </section>

                <section class="password">
                    <p>비밀번호</p>
                    <input class="input" type="password" name="memberPw" id="memberPw">
                </section>

                <button id="loginBtn" class="loginBtn" type="submit">로그인</button>

		</form>

        
                <section class="findIdPwAndSingup">
                    <div class="findIdPw">
                    <a href="/member/findId">
                        아이디 찾기 
                    </a>
                    
                    <p> &nbsp;/&nbsp; </p>
                    
                    <a href="/member/findPassword">
                        비밀번호 찾기
                    </a>
                    </div>

                    <a href="/member/signUp">
                        회원가입
                    </a>
                </section>

                <hr>

                <section class="snsLogin">
                    <a href="#">
                        <img class="sns" src="/resources/img/common/main/logo(google).png" alt="">
                    </a>

                    <a href="#">
                        <img class="sns" src="/resources/img/common/main/logo(facebook).png" alt="">
                    </a>

                    <a href="#">
                        <img class="sns" src="/resources/img/common/main/logo(kakao).png" alt="">
                    </a>
                </section>


            </div>

        
    </main>

    <script src="/resources/js/login.js"></script>

</body>

</html>
