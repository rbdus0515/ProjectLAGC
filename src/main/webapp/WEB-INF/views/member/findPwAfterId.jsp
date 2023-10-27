<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>비밀번호 찾기</title>
            
                <link rel="stylesheet" href="/resources/css/member/findPassword.css" type="text/css">

        </head>

            <body>

                <!-- 홈 로고 ---------------------------------------------------------------------------------------->
                <a href="/">
                    <img id="homelogo" class="logo" src="/resources/img/common/main/logo.png" alt="">
                </a>


                <!-- id 입력 ---------------------------------------------------------------------------------------->
                <main>

                    <div class="content2">

                        <p class="findPwTitle">분실한 계정의 비밀번호 변경</p>

                        <form action="/member/changePw" method="post" id="emailFrm">

                            <section class="findPwContainer">

                                <div id="noUse">
                                    <input type="radio" name="wayToFindPw" class="findPwRadio" id="findPwByPhone"
                                        value="checkByPhone">
                                    <label for="findPwByPhone">
                                        휴대전화로 인증하기
                                    </label>

                                    <div class="contentContainer">

                                        <p>이름</p>
                                        <input type="text" name="name">

                                        <div>
                                            <p>전화번호</p>
                                            <input type="tel" name="phone" placeholder="'-' 제외">
                                            <button id="sendAuthKeyPhone" type="button" class="certifyBtn">인증번호
                                                받기</button>
                                        </div>

                                        <div>
                                            <p>인증번호 입력</p>
                                            <input type="text" name="checkPhone">
                                            <button id="certifyBtnPhone" type="button" class="certifyBtn">인증하기</button>
                                        </div>

                                        <span id="checkAuthKeyByPhone"></span>

                                    </div>

                                    <hr>

                                </div>


                                <div>
                                    <input type="radio" name="wayToFindPw" class="findPwRadio" id="findPwByEmail"
                                        value="checkByEmail" checked>
                                    <label for="findPwByEmail">
                                        이메일로 인증하기
                                    </label>

                                    <div class="contentContainer">

                                        <p>이름</p>
                                        <input type="text" name="memberName" id=memberName>

                                        <div>
                                            <p>이메일</p>
                                            <input type="email" name="memberEmail" id="memberEmail">
                                            <button id="sendAuthKeyEmail" type="button" class="certifyBtn">인증번호
                                                받기</button>
                                        </div>

                                        <div>
                                            <p>인증번호 입력</p>
                                            <input type="text" name="checkEmail" id="checkEmail">
                                            <button id="certifyBtnEmail" type="button" class="certifyBtn">인증하기</button>
                                        </div>

                                        <div id="authKeyMessage"></div>
                                        <input type="hidden" name="memberId" value="${memberId}">
                                    </div>

                                    <hr>

                                </div>

                                <div class="btnSection">
                                    <button class="btn">다음으로</button>
                                    <a href="/member/findPwBeforeId" class="btn">돌아가기</a>
                                </div>

                            </section>

                        </form>




                    </div>


                </main>
            </body>


        <script src="/resources/js/findPw.js"></script>



        </html>