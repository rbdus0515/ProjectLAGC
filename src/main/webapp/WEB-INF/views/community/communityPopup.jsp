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
            <form class="popupForm" action="/" method="post">
                       
                       <div id="CCSec1TopBlank"></div>
                       
	            <section class="CCSec1">
	    
	                <section id="com-top-l-sec">
	                    
	                    <section id="comProfileImgSec">
	                    
	                    	<c:choose>
	                    		<c:when test="${not empty loginMember}">
	                    			<img src="${loginMember.memberProfileImage}" id="com-cuteGhost"/>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<img src="/resources/img/common/main/프로필아이콘.png" id="com-cuteGhost"/>
	                    		</c:otherwise>
	                    	</c:choose>
	                    	
	                    </section>
	    
	                    <section id="cComProfileNickname">
	                    	<c:choose>
	                    		<c:when test="${not empty loginMember}">
	                       			<p>${loginMember.memberNickname}</p>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<p></p>
	                    		</c:otherwise>
	                    	</c:choose>
	                    </section>
	    
	                </section>
	            
	                <section id="com-top-m-sec">
	                    <div id="comTitleDiv" class="comTitleDiv">
	                    	<c:choose>
	                    		<c:when test="${not empty loginMember}">
	                    			<input id="Title" name="inputTitle" placeholder="제목을 입력해주세요."></input>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<input id="Title" name="inputTitle" placeholder="로그인 후 이용 가능." readonly="readonly"></input>
	                    		</c:otherwise>
	                    	</c:choose>
	                    </div>
	                    <input id="loginMemberNo" type="hidden" value="${loginMember.memberNo}">
	                </section>
	    
	                <section id="com-top-r-sec">
	                    <img src="/resources/img/community/Vector.png" id="com-XIcon">
	                </section>
	            </section>
	    
	            <section class="CCSec2">
	                <div id="com-pop-mainComment">
	
	                    <section id="comContentDiv">
	                    	<c:choose>
	                    		<c:when test="${not empty loginMember}">
	                    			<textarea name="inputContent" placeholder="내용을 입력해주세요."></textarea>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<textarea name="inputContent" readonly="readonly"></textarea>
	                    		</c:otherwise>
	                    	</c:choose>
	                        
	                    </section>
	                    
	                    <section>
	                    
	                            <button type="submit" class="editDelete-button" id="edit-button">수정</button>
	                        
	                            <button type="button" class="editDelete-button" id="delete-button" onclick="">삭제</button>
	                        
	                    </section>
	    
	                </div>
	            </section>
	            
            </form>
    
            <section class="CCSec3">
                <div id="pop-botBox">
                	<!-- ajax 반복 구문 -->
                    <section id="ajaxSec" class="CCViewSec">
                        <!-- 반복 section -->
                        <section class="pop-botBox-sec">
        					<!-- 프로필 부분 sec -->
                            <section class="pop-botBox-profileSec">
        						<!-- 프로필 부분 img sec -->
                                <section class="pop-botBox-profileSec-topSec">
                                    <img src="/semiProjectImage/가면 캐릭.jpg" class="pop-botBox-profileImges">
                                </section>
        						<!-- 프로필 이름 부분 -->
                                <section class="pop-botBox-profileSec-botSec">
                                    <p>김돌쇠</p>
                                </section>
        
                            </section>
        					<!-- 댓글 부분 sec -->
                            <section class="pop-botBox-doubleComment-sec">
                            	<!-- 댓글 부분 div -->
                                <div class="pop-botBox-doubleComment-box">
                                    <!-- 댓글 컨텐트 -->
                                    <section class="pop-botBox-doubleComment-box-left">
                                        <p>뭐먹지 ㅜㅜ</p>
                                    </section>
        							<!-- 삭제 버튼 sec -->
                                    <section class="pop-botBox-doubleComment-box-right">                          
                                        <button>
                                            <img src="/resources/img/community/Vector.png" class="com-doubleComment-XIcon">
                                        </button>
                                    </section>
                                </div>
                            </section>
        
                        </section>
        
                        
                    </section>
    
    
                    <section id="blankForHorizon"></section>
    
                    <section id="insertCCommentSec">
    
                        <form id="upload" name="upload">
                            
                            <section id="myComment-l-sec">
                            	<c:choose>
                            	
                            		<c:when test="${not empty loginMember }">
                            			 <img src="${loginMember.memberProfileImage }" class="pop-botBox-profileImges">
                            		</c:when>
                            		<c:otherwise>
                            			<img src="/resources/img/common/main/프로필아이콘.png" class="pop-botBox-profileImges">
                            		</c:otherwise>
                            	</c:choose>
                                
                            </section>
        
                            <section id="myComment-r-sec">
                                <div id="myComment-write-sec">
        
                                    <section>
                                    	<c:choose>
                                    		<c:when test="${not empty loginMember }">
                                    			<textarea id="myComment-write" name="text" placeholder="댓글을 입력해주세요."></textarea>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<textarea id="myComment-write" name="text" placeholder="로그인 후 이용해주세요." readonly="readonly"></textarea>
                                    		</c:otherwise>
                                    	</c:choose>
                                    	
                                        
                                    </section>
        
                                    <section>
                                    	<c:if test="${not empty loginMember }">                                    	
	                                        <button id="uploadBtn" type="submit">올리기</button>
                                    	</c:if>
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