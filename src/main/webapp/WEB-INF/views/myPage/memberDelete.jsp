<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필 관리</title>

    <link rel="stylesheet" href="/resources/css/myPage/memberDelete.css" type="text/css">
</head>

<body>

<!-- 홈 로고 ---------------------------------------------------------------------------------------->
    <a href="/">
        <img class="logo" src="/resources/img/common/main/logo.png" alt="">
    </a>

<!-- 메인 ---------------------------------------------------------------------------------------->    
    <main class="mainContainer">

        <form action="/member/memberDelete" method="post" id="memberDelete" >

<!-- 정보 입력 ---------------------------------------------------------------------------------------->    

                <section class="delete">
                 
                    <a href="/">
                        <img id="homelogo" class="logo" src="/resources/img/common/main/logo.png" alt="">
                    </a>

                    <div>
                        <p>비밀번호</p>
                        <input class="input" type="password" name="memberPw" id="memberPw">
                    </div>
                    
                    <div>
                        <p>비밀번호 확인</p>
                        <input class="input" type="password" name="memberPwConfirm" id="memberPwConfirm">
                    </div>

                    <div class="confirmArea">
                        <input type="checkbox" name="deleteConfirm" id="deleteConfirm">
                        <p> 본 사이트에서 탈퇴하는 것에 동의합니다. </p>
                    </div>

                </section>

                <section class="btnContainer">
                    <button class="btn" type="submit"> 회원 탈퇴</button>
                    <a href="/" class="btn">돌아가기</a>
                </section>

            </div>

        </form>
    </main>

    <script src="/resources/js/memberDelete.js"></script>

</body>

</html>