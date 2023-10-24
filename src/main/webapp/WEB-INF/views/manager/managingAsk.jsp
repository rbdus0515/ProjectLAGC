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
                            <input type="radio" name="doneOrYet" id="notYet" value="notYet" class="doneOrYet"
                                checked></input>
                            <label for="notYet" class="askBtn">
                                미처리 문의
                            </label>
                            <!-- </a> -->

                            <!-- <a href="#"> -->
                            <input type="radio" name="doneOrYet" id="done" class="doneOrYet" value="done"></input>
                            <label for="done" class="askBtn">
                                처리된 문의
                            </label>
                            <!-- </a> -->

                        </div>
                        <br>
                        <hr>

                        <!---- 콘텐츠 ------------------------------------------------------------------------------------------>
                        <div class="askContent">

                            <div class="askContainer">

                                <div class="askDetail">

                                    <div>

                                        <div class="category">

                                            <div>이메일</div>
                                            <div>휴대폰</div>
                                            <div>제목</div>
                                            <div>작성자</div>

                                        </div>

                                        <div class="asker">

                                            <div id="askerEmail"></div>
                                            <div id="askerPhone"></div>
                                            <div id="QNATitle"></div>
                                            <div id="askerNickname"> </div>

                                        </div>

                                    </div>

                                    <div>
                                        <div class="whatPeopleAsk">

                                        </div>
                                    </div>

                                    <form action="">

                                        <div class="answer">
                                            <p>답변</p>
                                            <textarea class="answerArea" name="" id="" style="resize: none;"></textarea>
                                            <button class="answerBtn"></button>
                                        </div>

                                    </form>

                                </div>
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

            <script src="/resources/js/managingAsk.js"></script>
        </body>

        </html>