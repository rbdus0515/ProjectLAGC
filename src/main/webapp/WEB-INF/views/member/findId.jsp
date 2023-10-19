<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>

    <link rel="stylesheet" href="/resources/css/member/findId.css">
</head>

<body>

<!-- 홈 로고 --------------------------------------------------------------------------------------->
    <a href="/">
        <img id="homelogo" class="logo" src="/resources/img/logo.png" alt="">
    </a>

<!-- 메인 화면 ------------------------------------------------------------------------------------->
    <main>

        <p class="findIdTitle">아이디 찾기</p>

        <form action="#" method="post">

            <section class="findIdContainer">
                
                <div>

                        <input type="radio" name="wayToFindId" class="findIdRadio" id="findIdByPhone" value="checkByPhone" checked> 
                        <label for="findIdByPhone">
                            휴대전화로 인증하기
                        </label>
                        
                        <div class="contentContainer">
                            
                            <p>이름</p>
                            <input type="text" name="name">
                            
                            <div>
                                <p>전화번호</p>
                                <input type="tel" name="phone" placeholder="'-' 제외">
                                <button id="sendAuthKeyPhone" type="button" class="certifyBtn">인증번호 받기</button>
                            </div>
                            
                            <div>
                                <p>인증번호 입력</p>
                                <input type="text" name="checkPhone">
                                <button id="certifyBtnPhone" type="button" class="certifyBtn">인증하기</button>
                            </div>

                            <span id="checkAuthKeyByPhone"></span>
                        </div>
                        
                    </div>
                    
                    <hr>
                    
                    <div>
                        <input type="radio" name="wayToFindId" class="findIdRadio" id="findIdByEmail" value="checkByEmail">
                        <label for="findIdByEmail">
                            이메일로 인증하기
                        </label>
                        
                        <div class="contentContainer">
                            
                            <p>이름</p>
                            <input type="text" name="name">
                            
                            <div>
                                <p>이메일</p>
                                <input type="email" name="phone">
                                <button id="sendAuthKeyEmail" type="button" class="certifyBtn">인증번호 받기</button>
                            </div>

                            <div>
                                <p>인증번호 입력</p>
                                <input type="text" name="checkEmail">
                                <button id="certifyBtnEmail" type="button" class="certifyBtn">인증하기</button>
                            </div>

                            <span id="checkAuthKeyByEmail"></span>
                            
                        </div>
                        
                    </div>
                    
                <hr>    
                
                <button id="submitBtn">아이디 찾기</button>
                
            </section>
            
        </form>
        
    </main>



</body>

</html>
