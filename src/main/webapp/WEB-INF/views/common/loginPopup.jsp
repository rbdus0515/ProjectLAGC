<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginPopup</title>

    <link rel="stylesheet" href="/resources/css/common/loginPopup.css">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
    </style>
</head>
<body>

	<div id="loginPopupModalContainer" class="hidden">

	<section id="main-container">
        
        <div id="close-container">
            <button type="button" id="close-btn">
                <img src="/resources/img/닫기버튼.png" alt="">
            </button>
        </div>

        <section id="pw-info">
            <div class="margin"></div>
            
            <div id="logo-pw-section">
                <img src="/resources/img/로고.png">
                <section id="pw-section">
                    <p>로그인이 완료되었습니다.</p>
                    <p>${loginMember.memberId}님</p>
                    <p>반갑습니다.</p>
                </section>
                <a href="/"><button id="toHomeBtn">홈으로</button></a>
            </div>
            
            <div class="margin"></div>
        </section>
        
    </section>
    
   </div>

</body>
</html>