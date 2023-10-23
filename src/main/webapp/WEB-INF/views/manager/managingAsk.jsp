<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>1:1문의(관리자)</title>

    <link rel="stylesheet" href="/resources/css/manager/managingAskOfAdmin.css">
</head>

<body>

    <section>
<!----- 제목 ------------------------------------------------------------------------------------------>
        <div class="topTitle">1대1 문의</div>

<!----- 메인 ------------------------------------------------------------------------------------------>
        <div class="content">

<!----- left 공백-------------------------------------------------------------------------------------->
            <div id="l_blank"></div>

<!----- 문의 분류 --------------------------------------------------------------------------------------->
            <div id="main">

                <!-- top -->
                <div class="askBtnContainer">
                
                    <!-- <a href="#"> -->
                        <button type="button" class="askBtn">미처리 문의</button>
                    <!-- </a> -->
                    
                    <!-- <a href="#"> -->
                        <button type="button" class="askBtn">처리된 문의</button>
                    <!-- </a> -->
                    
                </div>
                <hr>
                
<!---- 콘텐츠 ------------------------------------------------------------------------------------------>
                <div class="askContent">

                    <div class="askDetail">
                        
                        <div>

                            <div class="category">
    
                                <div>분류</div>
                                <div>이메일</div>
                                <div>휴대폰</div>
                                <div>제목</div>
                                <div>작성자</div>
                                
                            </div>
    
                            <div class="asker">
    
                                <div>여행지</div>
                                <div>hong9@gamil.com</div>
                                <div>010-1234-1234</div>
                                <div>동궁과 월지 문의</div>
                                <div>홍길동</div>
    
                            </div>

                        </div>

                        <div>
                            <div class="whatPeopleAsk">
                                <p>동궁과 월지 운영시간 알려주세요</p>
                            </div>
                        </div>

                        <form action="">

                            <div class="answer">
                                <p>답변</p>
                                <textarea class="answerArea" name="" id="" style="resize: none;"></textarea>
                                <button class="answerBtn">답변 제출하기</button>
                            </div>
                            
                        </form>
                        
                    </div>

                 
                    
                                          
                    </div>
                   
                </div>



                <!-- bottom -->
               
            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>
    </section>



</body>

</html>