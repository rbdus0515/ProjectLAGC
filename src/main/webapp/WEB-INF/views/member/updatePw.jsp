<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>프로필 관리</title>

            <link rel="stylesheet" href="/resources/css/member/updatePw.css" type="text/css">
        </head>

        <body>

		<c:if test="${not empty msg}">

		<script>
			alert('${msg}')
		</script>

		</c:if>
	<!-- 홈 로고 ---------------------------------------------------------------------------------------->
            <a href="/">
                <img id="homelogo" class="logo" src="/resources/img/common/main/logo.png" alt="">
            </a>

            <!-- 메인 ---------------------------------------------------------------------------------------->
            <main class="mainContainer">

                <form action="/member/updatePw" method="post" id="updatePw">


                    <!-- 정보 입력 ---------------------------------------------------------------------------------------->

                    <section class="delete">

                        <a href="/">
                            <img id="homelogo" class="logo" src="/resources/img/common/main/logo.png" alt="">
                        </a>

                        <p class="updatePwTitle">비밀번호 변경</p>

                        <br><br>

                        <div>
                            <p>현재 비밀번호</p>
                            <input class="input" type="password" name="memberPw" id="memberPw">
                        </div>
                        
                        <br>
                        <hr>
                        <br>

                        <div>
                            <p>바꿀 비밀번호</p>
                            <input class="input" type="password" name="newMemberPw" id="newMemberPw">
                        </div>

                        <div>
                            <p>바꿀 비밀번호 확인</p>
                            <input class="input" type="password" name="newMemberPwConfirm" id="newMemberPwConfirm">
                        </div>
                        
                    </section>

                    <div><span id="pwMessage">영어,숫자,기호(!,@,#,-,_) 6~20글자 사이로 입력하세요.</span></div>
                    
                    <section class="btnContainer">
                        <button class="btn" type="submit">수정</button>
                        <a class="btn" href="/myPage/managingProfile">뒤로가기</a>
                    </section>

                    </div>

                </form>
            </main>

            <script src="/resources/js/updatePw.js"></script>


    

        </html>