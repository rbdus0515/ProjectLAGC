<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>noticeDetail</title>

    <link rel="stylesheet" href="/resources/css/notice/noticeDetail.css">
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
                <div id="subject">공지사항</div>
                <form action="/notice/update" method="GET">
                	<!-- 공지사항 수정을 위한 input type hidden으로 noticeNo KEY 넘기기 -->
                	<input type="hidden" name="noticeNo" value="${notice.noticeNo}"> 
	                <!-- top -->
	                <div id="main-t">
	                    <div id="main-t1"><hr></div>
	                    <div id="main-t2">
		                    <!-- 관리자일 경우 -->
		                   	<c:if test="${loginMember.memberManagerFlag == 'Y'}">
		                    	<input type="text" name="noticeTitle" id="noticeTitle" value="${notice.noticeTitle}">
		                    </c:if>
	                    
		                    <!-- 관리자가 아닐 경우 -->
		                    <c:if test="${loginMember.memberManagerFlag != 'Y'}">
		                    	<input type="text" name="noticeTitle" id="noticeTitle" value="${notice.noticeTitle}" disabled>
	                    	</c:if>
	                    </div>
	                    
	                    <div id="main-t3"><hr></div>
	                </div>
	
	                <!-- center -->
	                <div id="main-c">
		                    <!-- 관리자일 경우 -->
		                   	<c:if test="${loginMember.memberManagerFlag == 'Y'}">
		                    	<textarea id="noticeDetail" name="noticeDetail">${notice.noticeDetail}</textarea>
		                    </c:if>
	                    
		                    <!-- 관리자가 아닐 경우 -->
		                    <c:if test="${loginMember.memberManagerFlag != 'Y'}">
		                    	<textarea id="noticeDetail" name="noticeDetail" disabled>${notice.noticeDetail}</textarea>
	                    	</c:if>
	                </div>
	
	                <!-- bottom -->
	                <div id="main-b">
	                    <div id="main-b1">
	                        <div id="main-b1-t"><hr></div>
	                        <div id="main-b1-c">
	                            <div id="pre-tit">
	                                <div id="pre-tit-l">이전 글</div>
	                                <div id="pre-tit-r"><a href="/notice/detail?noticeNo=${notice.preNoticeNo}">${notice.preNoticeTitle}</a></div>
	                            </div>
	                            <div id="nex-tit">
	                                <div id="nex-tit-l">다음 글</div>
	                                <div id="nex-tit-r"><a href="/notice/detail?noticeNo=${notice.nextNoticeNo}">${notice.nextNoticeTitle}</a></div>
	                            </div>
	                        </div>
	                        <div id="main-b1-b"><hr></div>
	                    </div>
	                    <div id="main-b2">
	                    	<c:if test="${loginMember.memberManagerFlag == 'Y'}">
		                        <!-- 수정/삭제 버튼-->
		                        <button type="submit" id="upd-btn">수정</button>
		                        <button type="button" id="del-btn" onclick="noticeDeleteConfirm(${notice.noticeNo})">삭제</button>
		                        <a href="/notice/noticeList"><button type="button" id="list-btn">목록으로</button></a>
	                        </c:if>
	                    </div>
	                </div>
                </form>
            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>

        <!-- bottom -->
       	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
       	
       	<script src="/resources/js/notice.js"></script>
    </section>
</body>
</html>