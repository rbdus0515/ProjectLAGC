<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/resources/css/community/community.css">
    <title>커뮤니티</title>

</head>

<body>
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<form>

        <secion id="communityPage">
            <section>커뮤니티</section>
            
            <section>
                <div id="local-hr-box">
                    <select id="localSelect">
                        <option value="seoul">서울</option>
                        <option value="gyungiIncheon">경기 인천</option>
                        <option value="gangwon">강원도</option>
                        <option value="jeolla">전라도</option>
                        <option value="gyeongsang">경상도</option>
                        <option value="chungcheong">충청도</option>
                        <option value="jeju">제주도</option>
                    </select>
                </div>
            </section>
            
            <section>
                <div id="community-peopleComment-container">
            	<c:forEach var="com" items="${list}" >        		
                    <section>
                        <div class="com-peopleImg-sec">
                        	<c:if test="${empty com.profileImg}">                     	
                            	<img class="com-peopleImg" src="/resources/img/common/main/프로필아이콘.png">
                        	</c:if>
                        </div>
    
                        <section class="com-peopleComment-sec">           
                            
                            <section class="com-peopleComment-top-sec">
                                <div>
                                    <a class="comPeopleTitle" id="test">
                                        ${com.communityTitle}
                                    </a>
                                </div>
                                <div></div>
                                <div>조회수 : ${com.readCount}</div>
                                <div>작성인 : ${com.nickName}</div>
                                <div>날짜 : ${com.createDt}</div>
                            </section>
                            
                            <div class="com-peopleComment-bot-sec">
                                <a class="comPeopleWrite" href="#">
                                    ${com.communityContent}
                                </a>
                            </div>
    
                        </section>
    
                    </section>
            	</c:forEach>
                </div>
            </section>
    
            <section>
                <div id="com-myComment-container">
    
                    <section>
                        <div id="com-myComment-imgBox">
                            <img id="com-myComment-img" src="/semiProjectImage/좀비.jpg">
                        </div>
                    </section>
    
                    <section>
                        <section id="com-input-sec">
                            <input id="inputCommentTitle" name="inputCommentTitle" placeholder="제목을 입력해 주세요.">
                            <textarea id="inputComment" placeholder="내용을 입력해주세요."></textarea>
                        </section>
    
                        <section id="com-upload-sec">
                            <button>올리기</button>
                        </section>                  
                    </section>
                    
                </div>
            </section>
        </secion>
    </form>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <jsp:include page="/WEB-INF/views/community/communityPopup.jsp"/>
    <script src="/resources/js/community.js"></script>
</body>

</html>
