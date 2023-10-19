<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <div id="m_tit">공지사항</div>
                <div><hr></div>
				
				<!--  for문 돌리기 공지사항 -->
				<c:forEach var="list" items="${list}" varStatus="vs">
	                <div class="m_cont">
	                    <div class="m_cont_tit">${list.noticeTitle}</div>
	                    <div class="m_cont_dt">${list.noticeUploadDate}</div>
	                </div>
	                <div><hr></div>
				</c:forEach>

                <div id="p_move">
                    <button class="fa-solid fa-angle-left" id="left-btn"></button>
                    <span id="num">1</span>
                    <button class="fa-solid fa-angle-right" id="right-btn"></button>
                </div>
            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>

        <!-- bottom -->
        <div id="bottom">
        	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
        </div>
    </section>
</body>
</html>
