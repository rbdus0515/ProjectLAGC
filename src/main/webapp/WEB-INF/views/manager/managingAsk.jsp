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

            <jsp:include page="/WEB-INF/views/common/header.jsp" />

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

                       
                            <input type="radio" name="doneOrYet" class="doneOrYet" id="notYet" checked ></input>
                            <label for="notYet" class="askBtn" onclick="showQNA('notYet')">
                                미처리 문의
                            </label>
                           

                            <input type="radio" name="doneOrYet" class="doneOrYet" id="done"></input>
                            <label for="done" class="askBtn" onclick="showQNA('done')">
                                처리된 문의
                            </label>
                    

                        </div>
                        <br>
                        <hr>

                        <!---- 콘텐츠 ------------------------------------------------------------------------------------------>
                        <div class="askContent" id="askContent">

                            <c:forEach var="qna" items="${list}">

                                    <div class="askDetail">

                                        <div class="memberContainer">

                                            <div class="category">

                                                <div>이메일</div>
                                                <div>휴대폰</div>
                                                <div>제목</div>
                                                <div>작성자</div>

                                            </div>

                                            <div class="asker">

                                                <div class="askerEmail">${qna.memberEmail}</div>
                                                <div class="askerPhone">${qna.memberPhone}</div>
                                                <div class="QNATitle">${qna.QNATitle}</div>
                                                <div class="askerNickname">${qna.memberNickname}</div>

                                            </div>

                                        </div>

                                        <div>
                                            <div class="whatPeopleAsk">${qna.QNAContent}</div>
                                        </div>

                                        <form action="/manager/insert">

                                            <div class="answer">
                                                <p>답변</p>
                                                <textarea class="answerArea" name="answerArea" id=""
                                                    style="resize: none;"></textarea>
                                                <button class="answerBtn">답변 달기</button>
                                            </div>

                                            <input type="hidden" name="qnaNo" value="${qna.QNANo}">

                                        </form>

                                    </div>

                            </c:forEach>

                        </div>

                    </div>



                </div>




                </div>

                </div>



                <!-- bottom -->

                </div>

                <!-- right -->
                <div id="r_blank"></div>
                </div>
            </section>

            <jsp:include page="/WEB-INF/views/common/footer.jsp" />

            <script src="/resources/js/managingAsk.js"></script>
        </body>

        </html>