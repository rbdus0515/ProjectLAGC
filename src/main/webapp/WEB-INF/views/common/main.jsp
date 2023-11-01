<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인 페이지</title>

<link rel="stylesheet" href="/resources/css/common/mainPage.css">

<style>
	@import
	url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
</style>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Aref+Ruqaa&family=Asap:ital,wght@1,600&family=Nanum+Myeongjo:wght@700&family=Noto+Sans+KR:wght@200&family=Rubik+Iso&display=swap');
</style>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Anton&family=Asap:ital,wght@1,600&family=Exo+2:wght@600&family=Exo:wght@700&family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&family=Qwitcher+Grypen:wght@400;700&family=Source+Code+Pro:ital,wght@1,900&display=swap');
</style>
</head>

<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	
	<!-- 메인페이지 최상단 -->
	<section id="main-container">
		<img id="mainPage-img" src="/resources/img/common/main/덕수궁 2.png">
		<section id="title-container">
			<span class="black-text">"</span> <span class="white-text">TRAVEL</span>
			<span class="black-text">KOREA</span> <span class="white-text">"</span>
		</section>
		
		<a href="#shortcut-recommend-place-btn">
			<button id="mainPage-btn1">	추천	여행지 보러 가기</button>
		</a>
				
		<button type="button">
			<img id="infoBtn" src="/resources/img/common/main/이용방법 버튼.png">
		</button>
		
		<a	href="#shortcut-region-place-btn">
			<button id="mainPage-btn2">지역별 여행지 보러 가기</button>
		</a> 
		
		<a href="#main-container"
			><img id="topBtn" src="/resources/img/common/main/탑버튼.png">
		</a>
		
		
	</section>

	<!-- 메인페이지 추천 여행지 -->
	<div id="shortcut-recommend-place-btn"></div>
	<section id="recommend-place">추천 여행지</section>
	<section id="category-menu">
		<section class="category-empty"></section>

		<section class="category">
			<button class="dropbtn">연령별</button>
			<div class="dropdown-category">
				<button type="button" value="20" class="recommendBtn">20대</button> 
				<button type="button" value="30" class="recommendBtn">30대</button>
				<button type="button" value="40" class="recommendBtn">40대</button>
				<button type="button" value="50" class="recommendBtn">50대 이상</button>
			</div>
		</section>

		<section class="category">
			<button class="dropbtn">구성원별</button>
			<div class="dropdown-category">
				<button type="button" value="solo" class="recommendBtn">혼자</button>
				<button type="button" value="friend" class="recommendBtn">친구</button>
				<button type="button" value="couple" class="recommendBtn">연인</button>
				<button type="button" value="family" class="recommendBtn">가족</button>
			</div>
		</section>

		<section class="category">
			<button class="dropbtn">계절별</button>
			<div class="dropdown-category">
				<button type="button" value="spring" class="recommendBtn">봄</button>
				<button type="button" value="summer" class="recommendBtn">여름</button>
				<button type="button" value="autumn" class="recommendBtn">가을</button>
				<button type="button" value="winter" class="recommendBtn">겨울</button>
			</div>
		</section>

		<section class="category">
			<button class="dropbtn">테마별</button>
			<div class="dropdown-category">
				<button type="button" value="nature" class="recommendBtn">자연</button> 
				<button type="button" value="downtown" class="recommendBtn">도심</button>
				<button type="button" value="tradition" class="recommendBtn">전통</button>
				<button type="button" value="healing" class="recommendBtn">힐링</button>
				<button type="button" value="activity" class="recommendBtn">액티비티</button>
			</div>
		</section>

		<section class="category-empty"> </section>
	</section>
	
	<section id="chooseCategoryContainer">
		<section class="category-empty"></section>

		<div class="chooseCategory" id="ageCategory"></div>
		<div class="chooseCategory" id="memberCategory"></div>
		<div class="chooseCategory" id="seasonCategory"></div>
		<div class="chooseCategory" id="themeCategory"></div>

		<section class="category-empty"> </section>
	</section>
	
	<section id="recommend-img">
		<section class="recommend-empty"></section>
		<div><img class="recommend-place-btn" src="/resources/img/common/main/추천1.png"></div> <div><img class="recommend-place-btn" src="/resources/img/common/main/추천2.png"></div>
		<section class="recommend-empty"></section>
	</section>

	<!-- 메인페이지 지역별 여행지 -->
	<div id="shortcut-region-place-btn"></div>
	<section id="region-place">지역별 여행지</section>

	<!-- 서울 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=seo"><button class="region-btn">서울</button></a>
	</section>

	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="seo" items="${seoList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${seo.contentImg}">
						<p>${seo.travelName}</p>
						<input type="hidden" class="contentNo" value="${seo.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>
	

	<!-- 경기 / 인천 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=gyeinc"><button class="region-btn">경기 / 인천</button></a>
	</section>
	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="gyeinc" items="${gyeincList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${gyeinc.contentImg}">
						<p>${gyeinc.travelName}</p>
						<input type="hidden" class="contentNo" value="${gyeinc.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>

	<!-- 강원 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=gan"><button class="region-btn">강원</button></a>
	</section>

	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="gan" items="${ganList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${gan.contentImg}">
						<p>${gan.travelName}</p>
						<input type="hidden" class="contentNo" value="${gan.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>

	<!-- 충청 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=chu"><button class="region-btn">충청</button></a>
	</section>

	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="chu" items="${chuList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${chu.contentImg}">
						<p>${chu.travelName}</p>
						<input type="hidden" class="contentNo" value="${chu.contentNo}">
					</div>
				
			</c:forEach>

		</div>

		<div class="region-empty"></div>
	
	</section>

	<!-- 전라 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=jeo"><button class="region-btn">전라</button></a>
	</section>

	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="jeo" items="${jeoList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${jeo.contentImg}">
						<p>${jeo.travelName}</p>
						<input type="hidden" class="contentNo" value="${jeo.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>
	<!-- 경상 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=gye"><button class="region-btn">경상</button></a>
	</section>
	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="gye" items="${gyeList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${gye.contentImg}">
						<p>${gye.travelName}</p>
						<input type="hidden" class="contentNo" value="${gye.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>

	<!-- 제주 -->
	<section class="region-place-btn">
		<div id="button-magin"></div>
		<a href="/content/detail?area=jej"><button class="region-btn">제주</button></a>
	</section>

	<section class="region-place">

		<div class="region-empty"></div>
	
		<div class="contentContainer">

			<c:forEach var="jej" items="${jejList}" end="3">
				
					<div class="content">
						<img class="place-move-motion" src="${jej.contentImg}">
						<p>${jej.travelName}</p>
						<input type="hidden" class="contentNo" value="${jej.contentNo}">
					</div>
					
			</c:forEach>
		</div>

		<div class="region-empty"></div>
	
	</section>

	<div style="height: 300px"></div>

	

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<jsp:include page="/WEB-INF/views/common/howToUse.jsp" />
	<jsp:include page="/WEB-INF/views/content/popup.jsp" />

	<script src="/resources/js/main.js"></script>
	

	


</body>
</html>
