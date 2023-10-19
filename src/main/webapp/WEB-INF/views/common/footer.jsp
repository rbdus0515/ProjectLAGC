<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>풋터</title>

    <link rel="stylesheet" href="/resources/css/common/footer.css">
</head>

<body>

    <footer class="footer">

        <section class="logoSection">
            <a href="#">
                <img class="logo" src="/resources/img/common/main/로고.png">
            </a>
        </section>
        

        <section class="copyright">
            <p>Copyright c LAGC. All Rights Reserved.</p>
        </section>


        <section class="footerInformation">

            <div>
                <a href="#">
                    홈페이지 관련 정보
                </a>
            </div>
            <div>
                <a href="#">
                    개인정보 처리 방침
                </a>
            </div>

        </section>

    </footer>
    
    
    
   	<c:if test="${not empty msg}">

	<script>
	
		alert('${msg}')

	</script>

	</c:if>

</body>

</html>
