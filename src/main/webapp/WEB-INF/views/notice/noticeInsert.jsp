<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>noticeInsert</title>

    <link rel="stylesheet" href="/resources/css/notice/noticeInsert.css">
</head>
<body>
    <section>
        <!-- top -->
        <div id="top"></div>

        <!-- content -->
        <div id="content">
            <!-- left -->
            <div id="l_blank"></div>

            <!-- center -->
            <div id="main">
                <div id="subject">공지사항</div>
                <form action="/notice/insert" method="POST">
                    <!-- top -->
                    <div id="main-t">
                        <div id="main-t1"><hr></div>
                        <div id="main-t2">
                            <input type="text" name="noticeTitle" id="title" autocomplete="off" placeholder="제목 입력">
                        </div>
                        <div id="main-t3"><hr></div>
                    </div>

                    <!-- center -->
                    <div id="main-c">
                        <textarea name="noticeDetail" id="content2" autocomplete="off" placeholder="내용 입력"></textarea>
                    </div>

                    <!-- bottom -->
                    <div id="main-b">
                        <div><hr></div>
                        <div><button type="submit" id="add-btn">추가</button></div>
                    </div>
                </form>
            </div>

            <!-- right -->
            <div id="r_blank"></div>
        </div>

        <!-- bottom -->
        <div id="bottom"></div>
    </section>
</body>
</html>