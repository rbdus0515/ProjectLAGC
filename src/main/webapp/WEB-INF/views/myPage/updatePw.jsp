<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필 관리</title>

    <link rel="stylesheet" href="/resources/css/myPage/managingProfile.css" type="text/css">
</head>

<body>

<!-- 홈 로고 ---------------------------------------------------------------------------------------->
    <a href="/">
        <img id="homelogo" class="logo" src="/resources/img/common/main/logo.png" alt="">
    </a>

<!-- 메인 ---------------------------------------------------------------------------------------->    
    <main class="mainContainer">

        <form action="/member/info" method="post" id="updateFrm">


<!--프로필 사진 ---------------------------------------------------------------------------------------->    

            <div class="profileContainer">

                <div class="imgContainer">

                    <div class="img-wrapper">
                        <img src="/resources/img/common/main/춘식.png">
                    </div>

                    <div class="btn">
                        <label for="chooseFile">
                            프로필 사진 변경
                        </label>
                    </div>
                    <input type="file" id="chooseFile" name="chooseFile" accept="image/*"  onchange="loadFile(this)">

                </div>

<!-- 정보 입력 ---------------------------------------------------------------------------------------->    

                <section class="myInfo">

                    <div>
                        <p>아이디</p>
                        <input class="input" type="text" name="memberId" id="memberId" value="${loginMember.memberId}">
                        <div id="idMessage"></div><br>
                    </div>
                    
                    <div>
                        <p>비밀번호</p>
                        <input class="input" type="password" name="memberPw" id="memberPw">
                    </div>
                    
                    <div>
                        <p>비밀번호 확인</p>
                        <input class="input" type="password" name="memberPwConfirm" id="memberPwConfirm">
                        <div id="pwMessage"></div><br>
                    </div>

                    <div>
                        <p>이름</p>
                        <input class="input" type="text" name="memberName" id="memberName" value="${loginMember.memberName}">
                        <div id="nameMessage"></div><br>
                    </div>
                    
                    <div>
                        <p>이메일</p>
                        <div class="emailCheck">
                            <input class="input" type="email" name="memberEmail" id="memberEmail" value="${loginMember.memberEmail}">
                            <button id="sendAuthKeyEmail" type="button" class="btn">인증번호 받기</button>
                        </div>
                        <div id="emailMessage"></div><br>
                    </div>

                    <div>
                         <p>인증번호 입력</p>
                         <div class="emailCheck">
                             <input class="input" type="text" name="checkEmail" id="checkEmail">
                             <button id="certifyBtnEmail" type="button" class="btn">인증하기</button>
                         </div>
                         <div id="authKeyMessage"></div><br>
                    </div>

                    <div>
                        <p>전화번호</p>
                        <input class="input" type="tel" name="memberPhone" id="memberPhone" placeholder="- 제외" value="${loginMember.memberPhone}">
                        <div id="phoneMessage"></div><br>
                    </div>

                    <div>
                        <p>닉네임</p>
                        <input class="input" type="text" name="memberNickname" id="memberNickname" value="${loginMember.memberNickname}">
                        <div id="nicknameMessage"></div><br>
                    </div>


                </section>

                <section class="btnContainer">
                    <button class="btn" type="submit">수정</button>
                    <a href="/member/updatePw"><button class="btn" type="button">비밀번호 변경</button></a>
                    <a href="/member/delete"><button class="btn" type="button">회원 탈퇴</button></a>
                </section>

            </div>

        </form>
    </main>

    <script src="/resources/js/managingProfile.js"></script>

</body>

</html>