<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
         <section id="pw-info">
            <div class="margin"></div>
            
            <div id="logo-pw-section">
                <img src="/resources/img/common/main/로고.png">
                
                <section id="pw-section">
                    <p>회원님의 아이디는</p>
                    <p>' ${id} ' 입니다.</p>
                </section>
                
                <a href="/"><button id="toHomeBtn">홈으로</button></a>
            
            </div>
            
            <div class="margin"></div>
        </section>
        
    </section>
    
   </div>

</body>
</html>