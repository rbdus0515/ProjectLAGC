<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>콘텐츠 팝업창</title>
<link rel="stylesheet" href="/resources/css/content/popup.css"
	type="text/css">

</head>

<body >

	<div id="modalContainerPopup" class="hidden">

		<div id="mainContainer">

			<!-- X버튼 ----------------------------------------------------------------------------------------->
			<button type="button" id="closeBtnPopup">
				<img src="/resources/img/X버튼.png" alt="">
			</button>
			<!-- 사진 ------------------------------------------------------------------------------------------->

			<div class="container">

				<section class="photoSection">

					<div class="popupTitle">
						<p>충주 탑평리</p>

						<!-- 하트 이미지 ------------------------------------------------------------------------------------>
						<div class="heart-container" title="Like">
							<input type="checkbox" class="checkbox" id="Give-It-An-Id">
							<div class="svg-container">
								<svg viewBox="0 0 24 24" class="svg-outline"
									xmlns="http://www.w3.org/2000/svg">
                                <path
										d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Zm-3.585,18.4a2.973,2.973,0,0,1-3.83,0C4.947,16.006,2,11.87,2,8.967a4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,11,8.967a1,1,0,0,0,2,0,4.8,4.8,0,0,1,4.5-5.05A4.8,4.8,0,0,1,22,8.967C22,11.87,19.053,16.006,13.915,20.313Z">
                                </path>
                            </svg>
								<svg viewBox="0 0 24 24" class="svg-filled"
									xmlns="http://www.w3.org/2000/svg">
                                <path
										d="M17.5,1.917a6.4,6.4,0,0,0-5.5,3.3,6.4,6.4,0,0,0-5.5-3.3A6.8,6.8,0,0,0,0,8.967c0,4.547,4.786,9.513,8.8,12.88a4.974,4.974,0,0,0,6.4,0C19.214,18.48,24,13.514,24,8.967A6.8,6.8,0,0,0,17.5,1.917Z">
                                </path>
                            </svg>
								<svg class="svg-celebrate" width="100" height="100"
									xmlns="http://www.w3.org/2000/svg">
                                <polygon points="10,10 20,20"></polygon>
                                <polygon points="10,50 20,50"></polygon>
                                <polygon points="20,80 30,70"></polygon>
                                <polygon points="90,10 80,20"></polygon>
                                <polygon points="90,50 80,50"></polygon>
                                <polygon points="80,80 70,70"></polygon>
                            </svg>
							</div>
						</div>

						<!-- 하트 이미지 --------------------------------------------------------------------------------------->

					</div>

					<div class="popupImg">
						<img src="/resources/img/탑평리.jpg">
					</div>

					<div class="popupFooter">
						<a
							href="https://www.heritage.go.kr/heri/cul/culSelectDetail.do;jsessionid=1fVzDKMbFpmQaiPCk012CXqgrFBbI2Rra1wIdrV1vvbvRkTyxvitlrkn7JhUGzk8.cpawas2_servlet_engine1?pageNo=1_1_2_0&ccbaCpno=1113300060000"
							target="_blank"> 자세히 보기 </a> <a href="#"> 내 일정 추가 </a>

					</div>

				</section>



				<!-- 설명, 후기------------------------------------------------------------------------------------>

				<section class="explainSection">

					<div class="explainContainer">

						<p class="title">설명</p>

						<div class="explain">
							<p>
								충청북도 충주시 중앙탑면 탑평리에 있는 통일 시대의 석탑. <br> 8세기에서 9세기 사이에 세워진 것으로
								추정된다.
							</p>
						</div>

					</div>

					<div class="commentContainer">
						<p class="title">후기</p>

						<div class="comment">
							<p>후기 1</p>
						</div>
						<div class="comment">
							<p>후기 2</p>
						</div>
						<div class="comment">
							<p>후기 3</p>
						</div>

						<form action="">

							<div class="textArea">
								<textarea class="commentArea" id="" placeholder="글을 입력해주세요"
									style="resize: none;"></textarea>
								<button class="button" type="submit">올리기</button>
							</div>

						</form>

					</div>

				</section>

			</div>

		</div>
	</div>
	
	<script src="/resources/js/popup.js"></script>
</body>

</html>