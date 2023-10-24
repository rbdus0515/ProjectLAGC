<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 업로드,수정 팝업</title>

    <link rel="stylesheet" href="/resources/css/manager/adminEditPopUp.css">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
    </style>

</head>
<body>
	<div id="modalContainerPopup" class="hidden">
	    <form action="/content/adminEditPopUp" method="POST" name="" enctype="multipart/form-data">
	        <!-- 닫기 버튼 -->
	        <div id="close-container">
	        
	            <div class="div1">
	                <section id="title-category-place-imgFile">
	                    <select>
	                        <option selected name="ageCate" value="none">연령별</option>
	                        <option name="ageCate" value="20">20대</option>
	                        <option name="ageCate" value="30">30대</option>
	                        <option name="ageCate" value="40">40대</option>
	                        <option name="ageCate" value="50">50대 이상</option>
	                    </select>
	                    
	                    <select>
	                        <option selected name="memberCate" value="none">구성원별</option>
	                        <option name="memberCate" value="solo">개인</option>
	                        <option name="memberCate" value="friend">친구</option>
	                        <option name="memberCate" value="couple">연인</option>
	                        <option name="memberCate" value="family">가족</option>
	                    </select>
	                    
	                    <select>
	                        <option selected name="seasonCate" value="none">계절별</option>
	                        <option name="seasonCate" value="spring">봄</option>
	                        <option name="seasonCate" value="summer">여름</option>
	                        <option name="seasonCate" value="autumn">가을</option>
	                        <option name="seasonCate" value="winter">겨을</option>
	                    </select>
	                    
	                    <select>
	                        <option selected name="themeCate" value="none">테마별</option>
	                        <option name="themeCate" value="nature">자연</option>
	                        <option name="themeCate" value="downtown">도심</option>
	                        <option name="themeCate" value="tradition">전통</option>
	                        <option name="themeCate" value="healing">힐링</option>
	                        <option name="themeCate" value="activity">액티비티</option>
	                    </select>
	                </section>
	            </div>
	        
	            <button type="button" id="closeBtnPopup">
	                <img src="/resources/img/common/main/닫기버튼.png" alt="">
	            </button>
	        </div>
	
	        <div class="container">
	
	            <!-- 왼쪽부분(여행지명, 카테고리, 지역, 사진업로드, 위도, 경도, 링크) -->
	            <div class="div1">
	
	                <section id="title-category-place-imgFile">
	
	                    <input type="text" name="placeTitle" id="input-place"  placeholder="여행지명">
	                        
	                    <select>
	                        <option selected name="locationCate" value="none">지역</option>
	                        <option name="locationCate" value="seo">서울</option>
	                        <option name="locationCate" value="gyeinc">경기/인천</option>
	                        <option name="locationCate" value="gan">강원</option>
	                        <option name="locationCate" value="chu">충청</option>
	                        <option name="locationCate" value="jeo">전라</option>
	                        <option name="locationCate" value="gye">경상</option>
	                        <option name="locationCate" value="jej">제주</option>
	                    </select>
	
	                    <label for="imageInput">
	                        파일선택
	                    </label>
	                    <input type="file" name="uploadPlaceImg" id="imageInput">
	
	                </section>
	
	                <section id="placeZY">
	                    <div>위도 : <input name="latitude" class="input-placeZY"></div>
	                    <div>경도 : <input name="longitude" class="input-placeZY"></div>
	                </section>
	
	                <section id="place-img">
	                    <img id="uploadPlaceImg" src="">
	                </section>
	
	                <section id="info-url-upload-btn">
	                    <div>링크 : 
	                        <input type="url" name="placeUrl" id="place-info-url"  placeholder="관련 사이트 링크">
	                    </div>
	                    <button type="button" id="upload-btn">업로드</button>
	                </section>
	            </div> 
	            
	            <!-- 오른쪽 부분 (설명, 후기) -->
	            <div id="div2">
	                <section id="place-info">설명
	                    <textarea name="placeInfo" id="input-info" style="resize: none;"></textarea>
	                </section>
	                <section id="review-controll">후기
	                    <p>DB에서 리스트 뽑아오기</p>
	                </section>
	            </div> 
	        </div>
	    </form>
   	</div> 
    <script src="/resources/js/adminEditPopUp.js"></script>
    
</body>
</html>