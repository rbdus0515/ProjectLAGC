<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- map에 저장된 값들을 각각 변수에 저장 --%>
<c:set var="pagination" value="${map.pagination}" />
<c:set var="list" value="${map.noticeList}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>noticeList</title>

    <link rel="stylesheet" href="/resources/css/notice/noticeList.css">

    <script src="https://kit.fontawesome.com/f821b57119.js" crossorigin="anonymous"></script>
</head>
<body>
    <section>
    	<jsp:include page="/WEB-INF/views/common/header.jsp" />
    
        <!-- top -->
        <div id="top"></div>

        <!-- content -->
        <div id="content">
            <!-- left -->
            <div id="l_blank"></div>

            <!-- center -->
            <div id="main">
                <div id="m_tit">
                    <div>공지사항</div>
                    <c:if test="${loginMember.memberManagerFlag == 'Y'}">
                    	<div><a href="/notice/insertPage"><button class="fa-solid fa-plus" id="plus-btn"></button></a></div>
                    </c:if>
                </div>
                <div><hr></div>
				
				<c:choose>
				
					<%-- 조회된 게시글 목록이 비어있거나 null 경우 --%>
					<c:when test="${empty list}">
						<!-- 게시글 목록 조회 결과가 비어있다면 -->
						<div class="m_cont" id="emptyNotice">게시글이 존재하지 않습니다.</div>
		                <div><hr></div>
					</c:when>
					
					<c:otherwise>
						<%-- 게시글 목록 조회 결과가 있다면 --%>
						<!--  for문 돌리기 공지사항 -->
						<c:forEach var="list" items="${list}" varStatus="vs">
			                <div class="m_cont" onclick="noticeDetail(${list.noticeNo})">
			                    <div class="m_cont_tit">${list.noticeTitle}</div>
			                    <div class="m_cont_dt">${list.noticeUploadDate}</div>
			                </div>
			                <div><hr></div>
						</c:forEach>
						
						<!-- 페이지 번호 영역 -->
		                <div class="pagination-area">
			                <ul class="pagination">
			                
			                    <!-- 첫 페이지로 이동 -->
			                    <li><a href="/notice/noticeList?cp=1">&lt;&lt;</a></li>
			
			                    <!-- 이전 목록 마지막 번호로 이동 -->
			                    <li><a href="/notice/noticeList?cp=${pagination.prevPage}">&lt;</a></li>
			
								
			                    <!-- 특정 페이지로 이동 -->
			                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
			                    	<c:choose>
			                    		<%-- 현재 보고있는 페이지 --%>
			                    		<c:when test="${i == pagination.currentPage}">
			                    			<li><a class="current">${i}</a></li>
			                    		</c:when>
			                    		
			                    		<%-- 현재 페이지를 제외한 나머지 --%>
			                    		<c:otherwise>
			                    			<li><a href="/notice/noticeList?cp=${i}">${i}</a></li>
			                    		</c:otherwise>
			                    	</c:choose>
			                    </c:forEach>
			                   
			                    <!-- 다음 목록 시작 번호로 이동 -->
			                    <li><a href="/notice/noticeList?cp=${pagination.nextPage}">&gt;</a></li>
			
			                    <!-- 끝 페이지로 이동 -->
			                    <li><a href="/notice/noticeList?cp=${pagination.maxPage}">&gt;&gt;</a></li>
			
			                </ul>
			            </div>
					</c:otherwise>
					
				</c:choose>

            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>

        <!-- bottom -->
        <div id="bottom">
        	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
        </div>
    </section>
    
    <script src="/resources/js/notice.js"></script>
</body>
</html>
