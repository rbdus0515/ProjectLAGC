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
	    <form action="/content/adminEditPopUp" method="POST" enctype="multipart/form-data">
	       <!-- 카테고리, 닫기 버튼 -->
	      <div id="close-container">
	        
	            <div class="div1">
	                <section id="title-category-place-imgFile">
	                    <select name="ageCode">
	                        <option selected>연령별</option>
	                        <option value="20">20대</option>
	                        <option value="30">30대</option>
	                        <option value="40">40대</option>
	                        <option value="50">50대 이상</option>
	                    </select>
	                    
	                    <select name="memberCode">
	                        <option selected>구성원별</option>
	                        <option value="solo">개인</option>
	                        <option value="friend">친구</option>
	                        <option value="couple">연인</option>
	                        <option value="family">가족</option>
	                    </select>
	                    
	                    <select name="seasonCode">
	                        <option selected>계절별</option>
	                        <option value="spring">봄</option>
	                        <option value="summer">여름</option>
	                        <option value="autumn">가을</option>
	                        <option value="winter">겨을</option>
	                    </select>
	                    
	                    <select name="themeCode">
	                        <option selected>테마별</option>
	                        <option value="nature">자연</option>
	                        <option value="downtown">도심</option>
	                        <option value="tradition">전통</option>
	                        <option value="healing">힐링</option>
	                        <option value="activity">액티비티</option>
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
	
	                    <input type="text" name="travelName" id="input-place"  placeholder="여행지명">
	                        
	                    <select name="areaCode">
	                        <option selected>지역</option>
	                        <option value="seo">서울</option>
	                        <option value="gyeinc">경기/인천</option>
	                        <option value="gan">강원</option>
	                        <option value="chu">충청</option>
	                        <option value="jeo">전라</option>
	                        <option value="gye">경상</option>
	                        <option value="jej">제주</option>
	                    </select>
	
	                    <label for="imageInput">
	                        파일선택
	                    </label>
	                    <input type="file" name="uploadPlaceImg" id="imageInput" accept="image/*">
	
	                </section>
	
	                <section id="placeZY">
	                    <div>위도 : <input name="latitude" class="input-placeZY"></div>
	                    <div>경도 : <input name="longitude" class="input-placeZY"></div>
	                </section>
	
	                <section id="place-img">
	                    <img id="uploadPlaceImg" src="/resources/img/common/main/닫기버튼.png">
	                </section>
	
	                <section id="info-url-upload-btn">
	                    <div>링크 : 
	                        <input type="url" name="placeUrl" id="place-info-url"  placeholder="관련 사이트 링크">
	                    </div>
	                    <button type="submit" id="upload-btn">업로드</button>
	                </section>
	            </div> 
	            
	            <!-- 오른쪽 부분 (설명, 후기) -->
	            <div id="div2">
	                <section id="place-info">설명
	                    <textarea name="placeInfo" id="input-info" style="resize: none;"></textarea>
	                </section>
	                <section id="review-controll">후기
	                    <section id="review-controll-section">
	                        <p>DB에서 리스트 뽑아오기</p>
	                        <button type="button" id="deleteBtn">
					                <img src="/resources/img/common/main/닫기버튼.png" alt="">
	                        </button>
	                    </section>
                	</section>
	            </div> 
	        </div>
	    </form>
   	</div> 
    <script src="/resources/js/adminEditPopUp.js"></script>
    
</body>
</html>