<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>detailPageSe</title>

    <link rel="stylesheet" href="/resources/css/content/seoul.css">

    <script src="https://kit.fontawesome.com/f821b57119.js" crossorigin="anonymous"></script>
</head>
<body>
    <section>
    	<jsp:include page="/WEB-INF/views/common/header.jsp" />
    	
        <!-- top -->
        <div id="top">"Seoul"</div>

        <!-- main -->
        <div id="main">
            <!-- 왼쪽 여백 -->
            <div id="leftArea"></div>

            <!-- 메인 이미지들 -->
            <div class="mainArea">
                <div class="imgArea">
                    
                    <!-- for문 돌리기 이미지 -->
					<c:forEach var="img" items="${list}" varStatus="vs">
	                    <div class="placeSec">
	                        <div class="blank"></div>
	                        <div class="placeImg">
	                            <img src="${img.contentImg}" class="contImg">
	                        </div>
	                        <div class="placeTitSec">
	                            <div class="tit">
	                                ${img.travelName}
	                            </div>
	                            <c:if test="${loginMember.memberManagerFlag == 'Y'}">
		                            <div class="delArea">
		                                <button type="button" class="xBtn" onclick="contentDeleteConfirm(${img.contentNo}, '${img.areaCode}')">X</button>
		                            </div>
	                            </c:if>
	                            <input type="hidden" class="contentNo" value="${img.contentNo}">
	                        </div>
	                    </div>
					</c:forEach>
	
					<c:if test="${loginMember.memberManagerFlag == 'Y'}">
	                    <!-- 네번째 네개 이미지(+) -->
	                    <div class="placeSec" id="placePlus">
	                        <div class="blank"></div>
	                        <div class="placeImg">
	                            <button type="button" id="plusBtn">+</button>
	                        </div>
	                        <div class="placeTitSec">
	                            <div class="tit"></div>
	                            <div class="delArea"></div>
	                        </div>
	                    </div>
                    </c:if>
                </div>    
            </div>

            <!-- 오른쪽 여백 -->
            <div id="rightArea"></div>
        </div>

        <!-- bottom -->
        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    </section>
    
    <a href="#top"><img src="/resources/img/content/button/탑버튼.png" id="upBtn"></a>
        
	<c:choose>
    
    	<c:when test="${loginMember.memberManagerFlag == 'Y'}">
    	<!-- 관리자 팝업 -->
	        <jsp:include page="/WEB-INF/views/manager/adminEditPopUp.jsp" />
		</c:when>

		<c:otherwise>
        	<jsp:include page="/WEB-INF/views/content/popupForDetail.jsp" />
		</c:otherwise>

	</c:choose>    
        
    <script src="/resources/js/content.js"></script>
    <script src="/resources/js/adminEditPopUp.js"></script>
  
</body>
</html>
