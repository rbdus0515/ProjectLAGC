<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>searchPage</title>

    <link rel="stylesheet" href="/resources/css/common/searchPage.css">

    <script src="https://kit.fontawesome.com/f821b57119.js" crossorigin="anonymous"></script>
</head>
<body>
    <section>
    
    	<jsp:include page="/WEB-INF/views/common/header.jsp" />
    
        <!-- top -->
        <div id="top">&nbsp;</div>

        <!-- main -->
        <div id="main">
            <!-- 왼쪽 여백 -->
            <div id="leftArea"></div>

              <!-- 검색결과 구역 -->
              <div id="searchArea">
              
              	<!--  for문 돌리기 검색 조회 결과 -->
              	<c:forEach var="list" items="${list}" varStatus="vs">
	                <div class="searchResult">
	                    <!-- 검색 정보 -->
	                    <div class="searchInfo">
	                        <div class="imgSection">
	                            <!-- 이미지 -->
	                            <img src="${list.contentImg}" class="img">
	                        </div>
	                        <div class="infoSection">
	                            <div class="info">
	                                <!-- 제목 영역 -->
	                                <div class="titleSection">
	                                    <!--  지역명 -->
	                                    <div class="region">${list.area}</div>
	                                    <!-- 여행지명 -->
	                                    <div class="travelName">${list.travelName}</div>
	                                    <!-- 좋아요 관련 -->
	                                    <div class="like">
	                                        ${list.likeCount}개 &nbsp;
	                                        <i class="fa-solid fa-heart" class="heart-btn" style="color: #f93e63;"></i>
	                                    </div>
	                                </div>
	
	                                <!-- 설명 영역 -->
	                                <div class="contentSection">
	                                    ${list.placeInfo}
	                                </div>
	
	                                <!-- 자세히 보기 / 내 일정 추가 영역 -->
	                                <div class="linkSection">
	                                    <!-- 자세히 보기 -->
	                                    <div class="linkDetail"><a href="${list.placeUrl}">자세히 보기</a></div>
	
	                                    <!-- 내 일정 추가 -->
	                                    <div class="addMyPlan"><a href="#">내 일정 추가</a></div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!-- 하단 선 -->
	                    <div class="line"><hr></div>
	                </div>
                </c:forEach>
                
            </div>

            <!-- 오른쪽 여백 -->
            <div id="rightArea"></div>
        </div>

        
    </section>
    
    <!-- bottom -->
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <a href="#top"><img src="/resources/img/content/button/탑버튼.png" id="upBtn"></a>
  
</body>
</html>