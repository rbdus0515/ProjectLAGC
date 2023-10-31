<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>1:1문의</title>

<link rel="stylesheet" href="/resources/css/myPage/myPage.css">
</head>

<body>

	<div id="askContentModal" class="hidden">

		
		<!---- 콘텐츠 ------------------------------------------------------------------------------------------>
		<div class="askContent" >
			
			<button type="button" id="askCloseBtn">x</button>

			<div class="askDetail">
				
				<div class="memberContainer">
					
					<div class="category">
						
						<div>작성일시</div>
						<div>제목</div>
						<div>질문 내용</div>
						
					</div>
					
					<div class="asker">
						
						<div id="createDate" class="createDate"></div>
						<div id="QNATitle" class="QNATitle"></div>
						
					</div>
					
				</div>
				
				<div>
					<div id="whatPeopleAsk" class="whatPeopleAsk"></div>
				</div>
				
				
				
				<div class="answer">
					<p>답변</p>
					<div class ="answerArea" id="answerArea"> 답변 내용</div>
				</div>
				
				
				
			</div>
			
			
		</div>
		
	</div>
	</body>
	
</html>