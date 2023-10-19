<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/community/communityPopup.css"
	type="text/css">
<title>커뮤니티 팝업</title>
</head>
<body>
	
	<div id="modalContainer" class="hidden">

        <main id="communityPopup-container">
    
            <section>
    
                <section id="com-top-l-sec">
                    
                    <section>
                        <img src="/semiProjectImage/귀여운 유령.jpg" id="com-cuteGhost">
                    </section>
    
                    <section>
                        <p>달걀</p>
                    </section>
    
                </section>
    
                <section id="com-top-m-sec">
                    <div>
                        <input id="Title" name="inputTitle" placeholder="제목을 입력해주세요."></input>
                    </div>
                </section>
    
                <section id="com-top-r-sec">
                    <img src="/resources/img/community/Vector.png" id="com-XIcon">
                </section>
            </section>
    
            <section>
                <div id="com-pop-mainComment">
                    
                    <section>
                        <textarea placeholder="내용을 입력해주세요."></textarea>
                    </section>
                    
                    <section>
                        <a>
                            <button class="editDelete-button" id="edit-button">수정</button>
                        </a>
                        <a>
                            <button class="editDelete-button" id="delete-button">삭제</button>
                        </a>
                    </section>
    
                </div>
            </section>
    
            <section>
                <div id="pop-botBox">
    
                    <section class="pop-botBox-sec">
    
                        <section class="pop-botBox-profileSec">
    
                            <section class="pop-botBox-profileSec-topSec">
                                <img src="/semiProjectImage/가면 캐릭.jpg" class="pop-botBox-profileImges">
                            </section>
    
                            <section class="pop-botBox-profileSec-botSec">
                                <p>김돌쇠</p>
                            </section>
    
                        </section>
    
                        <section class="pop-botBox-doubleComment-sec">
                            <div class="pop-botBox-doubleComment-box">
                                
                                <section class="pop-botBox-doubleComment-box-left">
                                    <p>뭐먹지 ㅜㅜ</p>
                                </section>
    
                                <section class="pop-botBox-doubleComment-box-right">                          
                                    <button>
                                        <img src="/resources/img/community/Vector.png" class="com-doubleComment-XIcon">
                                    </button>
                                </section>
                            </div>
                        </section>
    
                    </section>
    
                    <section class="pop-botBox-sec">
    
                        <section class="pop-botBox-profileSec">
    
                            <section class="pop-botBox-profileSec-topSec">
                                <img src="/semiProjectImage/돌쇠.png" class="pop-botBox-profileImges">
                            </section>
    
                            <section class="pop-botBox-profileSec-botSec">
                                <p>왕대박</p>
                            </section>
    
                        </section>
    
                        <section class="pop-botBox-doubleComment-sec">
                            <div class="pop-botBox-doubleComment-box">
                                
                                <section class="pop-botBox-doubleComment-box-left">
                                    <p>나두요!</p>
                                </section>
    
                                <section class="pop-botBox-doubleComment-box-right">                          
                                    <button>
                                        <img src="/resources/img/community/Vector.png" class="com-doubleComment-XIcon">
                                    </button>
                                </section>
                            </div>
                        </section>
    
                    </section>
    
                    <section class="pop-botBox-sec">
    
                        <section class="pop-botBox-profileSec">
    
                            <section class="pop-botBox-profileSec-topSec">
                                <img src="/semiProjectImage/로봇.jpg" class="pop-botBox-profileImges">
                            </section>
    
                            <section class="pop-botBox-profileSec-botSec">
                                <p>다랑어</p>
                            </section>
    
                        </section>
    
                        <section class="pop-botBox-doubleComment-sec">
                            <div class="pop-botBox-doubleComment-box">
                                
                                <section class="pop-botBox-doubleComment-box-left">
                                    <p>하염</p>
                                </section>
    
                                <section class="pop-botBox-doubleComment-box-right">                          
                                    <button>
                                        <img src="/resources/img/community/Vector.png" class="com-doubleComment-XIcon">
                                    </button>
                                </section>
                            </div>
                        </section>
    
                    </section>
    
                    <section></section>
    
                    <section>
    
                        <form id="upload" name="upload">
                            
                            <section id="myComment-l-sec">
                                <img src="/semiProjectImage/귀여운 유령.jpg" class="pop-botBox-profileImges">
                            </section>
        
                            <section id="myComment-r-sec">
                                <div id="myComment-write-sec">
        
                                    <section>
                                        <textarea id="myComment-write" name="text" placeholder="댓글을 입력해주세요."></textarea>
                                    </section>
        
                                    <section>
                                        <button id="uploadBtn">올리기</button>
                                    </section>
        
                                </div>
                            </section>
    
                        </form>
    
    
                    </section>
                    
                </div>
            </section>
        </main>

    </div>
    
    

</body>
</html>