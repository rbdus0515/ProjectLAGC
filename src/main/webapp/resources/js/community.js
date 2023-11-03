
// 모달 히든 및 x 버튼 꺼짐
const modalContainer = document.getElementById('modalContainer');
const comXIcon = document.getElementById('com-XIcon');

comXIcon.addEventListener('click', () => {
  modalContainer.classList.add('hidden');
});

// 모달창 esc버튼 누르면 사라짐
(function(){
  document.addEventListener('keydown', function(e){
    const keyCode = e.keyCode;

    if(keyCode == 27){
      modalContainer.classList.add('hidden');
    }
  })
})();


// 커뮤니티 메인 ajax
const localSelect = document.getElementById("localSelect");

localSelect.addEventListener('change', () => {

  const areaCode = localSelect.options[localSelect.selectedIndex].value;

  fetch("/community/selectLocal?areaCode=" + areaCode)
  .then(resp => resp.json())
  .then(list => {

    console.log(list);
    
    const contentContainer = document.getElementById("community-peopleComment-container");
    contentContainer.innerHTML = "";
  
    for(var i in list) {
      
      const RSection = document.createElement("div");
      RSection.classList.add("repeatSection");

      const peopleImgSec = document.createElement("div");
      peopleImgSec.classList.add("com-peopleImg-sec");

      const peopleImg = document.createElement("img");
      peopleImg.classList.add("com-peopleImg");

      if(list[i].profileImg == null) {
        peopleImg.src = "/resources/img/common/main/프로필아이콘.png";
      }else{
        peopleImg.src = list[i].profileImg;
      }

      
      
      
      

      peopleImgSec.append(peopleImg);

      const PCSection = document.createElement("div");
      PCSection.classList.add("com-peopleComment-sec");

      const PCTSection = document.createElement("div");
      PCTSection.classList.add("com-peopleComment-top-sec");

      const PCDiv1 = document.createElement("div");
      PCDiv1.classList.add("PCDiv1");
      PCDiv1.setAttribute("id", `rep-${list[i].communityNo}`);
      PCDiv1.innerText = list[i].communityTitle;

      const PCDiv2 = document.createElement("div");
      PCDiv2.classList.add("PCDiv2");

      const PCDiv3 = document.createElement("div");
      PCDiv3.classList.add("PCDiv3");
      PCDiv3.innerText = "조회수 : " + list[i].readCount;

      const PCDiv4 = document.createElement("div");
      PCDiv4.classList.add("PCDiv4");
      PCDiv4.innerText = "작성인 : " + list[i].nickName;

      const PCDiv5 = document.createElement("div");
      PCDiv5.classList.add("PCDiv5");
      PCDiv5.innerText = "날짜 : " + list[i].createDt;

      const PCBSection = document.createElement("div");
      PCBSection.classList.add("com-peopleComment-bot-sec");
      PCBSection.innerText = list[i].communityContent;

      RSection.append(peopleImgSec);
      
      
      PCTSection.append(PCDiv1, PCDiv2, PCDiv3, PCDiv4, PCDiv5);
     
      PCSection.appendChild(PCTSection);
      PCSection.appendChild(PCBSection);



      RSection.append(PCSection);

      contentContainer.append(RSection);

    }

  })
  .catch(err => console.log(err));
});



document.addEventListener("click", (e) => {

  console.log(e.target);

  if(e.target.className == "PCDiv1"){

    modalContainer.classList.remove('hidden');

    const commNo = e.target.id.split("-")[1];

    console.log(commNo);

    fetch("/community/modal?communityNo=" + commNo)
    .then(resp => resp.json())
    .then(comboMap => {

      const ccomentList = comboMap.ccomentList;
      const selectComList = comboMap.selectComList;

      console.log(ccomentList);
      console.log(selectComList);



      // 모달창 커뮤니티 이미지
      const comProfileImgSec = document.getElementById("comProfileImgSec");
      comProfileImgSec.innerHTML = "";

      const comProfileImg = document.createElement("img");
      comProfileImg.setAttribute("id", "com-cuteGhost");
      comProfileImg.classList.add("comProfileImg");

      if(selectComList[0].profileImg == null){
        comProfileImg.src = "/resources/img/common/main/프로필아이콘.png";
      }else{
        comProfileImg.src = selectComList[0].profileImg;
      }

      comProfileImgSec.append(comProfileImg);



      // 모달창 커뮤니티 닉네임
      const cComProfileImgSec = document.getElementById("cComProfileNickname");
      cComProfileImgSec.innerHTML = "";
      cComProfileImgSec.innerText = selectComList[0].nickName;
      



      // ajax 컨테이너
      const ajaxSec = document.getElementById("ajaxSec");
      ajaxSec.innerHTML = "";




      // 모달창 커뮤니티 제목
      const loginMemberNo = document.getElementById("loginMemberNo").value; // 로그인 멤버 넘버

      const comTitleDiv = document.getElementById("comTitleDiv");
      comTitleDiv.innerHTML = "";
      
      const comTitle = document.createElement("div");
      comTitle.innerText = selectComList[0].communityTitle;
      comTitle.setAttribute("id", "Title");
      comTitle.setAttribute("name", "inputTitle");

      comTitleDiv.append(comTitle);

      if(loginMemberNo == selectComList.memberNo) {
        comTitle.setAttribute("placeholder", "제목을 입력해주세요.");
      } else {
        comTitle.setAttribute("readonly", "readonly");
      }



      // 삭제 버튼
      // const deleteButtonDiv = document.getElementById("delete-buttonDiv");
      // deleteButtonDiv.innerHTML = "";

      // const deleteATag = document.createElement("a");
      // deleteATag.setAttribute("id", "delete-button");
      // deleteATag.setAttribute("href", "/community/deleteCom?communityNo=" + selectComList[0].communityNo);
      // deleteATag.innerText = "삭제";

      // deleteButtonDiv.append(deleteATag);


      // 모달창 커뮤니티 컨텐트
      const comContentDiv = document.getElementById("comContentDiv");
      comContentDiv.innerHTML = "";

      const cCinputContent = document.createElement("textarea");
      cCinputContent.setAttribute("name", "communityContent");
      cCinputContent.setAttribute("placeholder", "내용을 입력해주세요.");
      cCinputContent.setAttribute("id", "cCinputContent");
      cCinputContent.innerText = selectComList[0].communityContent;

      comContentDiv.append(cCinputContent);

      // 삭제 수정 버튼
      const editButton = document.getElementById("edit-button");
      const deleteComBtn = document.getElementById("delete-button");
      const loginMemberManagerFl = document.getElementById("loginMemberManagerFl").value;


      console.log(loginMemberNo);
      console.log(selectComList[0].memberNo);
      console.log(loginMemberManagerFl);


      if(loginMemberNo == selectComList[0].memberNo || loginMemberManagerFl == 'Y') {

        deleteComBtn.setAttribute("onclick", "comDeleteConfirm(" + selectComList[0].communityNo + ")");

      }else {
        editButton.classList.add("hidden");
        deleteComBtn.classList.add("hidden");
      }

      // 커뮤니티 넘버 히든으로 만들기
      const editDeleteSection = document.getElementById("editDeleteSection");
      const hiddenCommunityNo = document.createElement("input");
      hiddenCommunityNo.setAttribute("type", "hidden");
      hiddenCommunityNo.setAttribute("name", "communityNo");
      hiddenCommunityNo.setAttribute("value", selectComList[0].communityNo);
     
      editDeleteSection.append(hiddenCommunityNo);

      // 커뮤니티 댓글에 커뮤니티 넘버 보내기 히든
      const comNoSec = document.getElementById("myComment-r-sec");
      const comNoHidden = document.createElement("input");
      comNoHidden.setAttribute("type", "hidden");
      comNoHidden.setAttribute("name", "communityNo");
      comNoHidden.setAttribute("value", selectComList[0].communityNo);
      comNoSec.append(comNoHidden);
      

      


      for(var cc in ccomentList){
        
        // 반복 section
        const PBS = document.createElement("div");
        PBS.classList.add("pop-botBox-sec");


        // -------------------------------------------------------

        // 프로필 부분 sec
        const PBP = document.createElement("section");
        PBP.classList.add("pop-botBox-profileSec");

        // 프로필 부분 img sec
        const PBPTSec = document.createElement("div");
        PBPTSec.classList.add("pop-botBox-profileSec-topSec");

        // 프로필 부분 img
        const peopleProfile = document.createElement("img");
        peopleProfile.classList.add("pop-botBox-profileImges");

        if(ccomentList[cc].profileImage != null) {
          peopleProfile.setAttribute("src", ccomentList[cc].profileImage);
        }else {
          peopleProfile.setAttribute("src", "/resources/img/common/main/프로필아이콘.png");
        }

        

        // 프로필 이름 부분
        const PBPBSec = document.createElement("div");
        PBPBSec.classList.add("pop-botBox-profileSec-botSec");
        PBPBSec.innerText = ccomentList[cc].memberNickname;

        
      
        // -----------------------------------------------------------

        // 댓글 부분 sec
        const CCommentSec = document.createElement("div");
        CCommentSec.classList.add("pop-botBox-doubleComment-sec");

        // 댓글 부분 댓글 넘버 히든으로 가져오기
        const CCommentNo = document.createElement("input");
        CCommentNo.setAttribute("value", ccomentList[cc].communityCommentNo);
        CCommentNo.setAttribute("type", "hidden");
        

        PBS.append(CCommentNo);

        // 댓글 부분 div
        const CCommentBox = document.createElement("div");
        CCommentBox.classList.add("pop-botBox-doubleComment-box");

        // 댓글 컨텐트
        const CCommentContent = document.createElement("div");
        CCommentContent.classList.add("pop-botBox-doubleComment-box-left");
        CCommentContent.innerText = ccomentList[cc].communityCommentContent;

        // 삭제 버튼 sec
        const deleteBtnSec = document.createElement("div");
        deleteBtnSec.classList.add("pop-botBox-doubleComment-box-right");


        console.log("로그인멤버넘버" + loginMemberNo);
        console.log("매니저 유무" + loginMemberManagerFl);
        console.log(ccomentList[cc].memberNo);

        // 삭제 버튼 이미지
        const deleteBtnImg = document.createElement("img");
        deleteBtnImg.setAttribute("src", "/resources/img/community/Vector.png");
        deleteBtnImg.classList.add("com-doubleComment-XIcon");

        // 삭제 버튼
        if(loginMemberNo == ccomentList[cc].memberNo || loginMemberManagerFl == 'Y') { 

          console.log("됐다");       
          const deleteBtn = document.createElement("a");
          deleteBtn.classList.add("deleteCCommentBtn");
          deleteBtn.setAttribute("href", "/community/deleteCComment?communityCommentNo=" + ccomentList[cc].communityCommentNo);
          deleteBtnSec.append(deleteBtn);
          deleteBtn.append(deleteBtnImg);
        }
        // const deleteBtn = document.createElement("button");
        // deleteBtn.classList.add("deleteCCommentBtn");
        // deleteBtn.setAttribute("type", "hidden");

        

       

        // --------------------------------------------------------------------------------

        ajaxSec.append(PBS);

        PBS.append(PBP);
        PBS.append(CCommentSec);

        PBP.append(PBPTSec);
        PBP.append(PBPBSec);

        PBPTSec.append(peopleProfile);

        CCommentSec.append(CCommentBox);
        CCommentBox.append(CCommentContent);
        CCommentBox.append(deleteBtnSec);

      }

    })
    .catch(err => console.log(err));
  }
});

// 커뮤니티 삭제 function
function comDeleteConfirm(communityNo) {

  console.log(communityNo);

  if(!confirm("정말 삭제 하시겠습니까?")) {
    return;
  }

  location.href = "/community/deleteCom?communityNo=" + communityNo;
  
}

// 커뮤니티 제목 내용 확인(비어있는지)
const insertCom = document.getElementById("insertCom");
const inputComTitle = document.getElementById("inputComTitle");
const inputCom = document.getElementById("inputCom");

insertCom.addEventListener("submit", e => {

  if(inputComTitle.value == "") {
    alert("제목을 입력해 주세요.");
    e.preventDefault();
    return;
  }

  if(inputCom.value == "") {
    alert("내용을 입력해 주세요.");
    e.preventDefault();
    return;
  }
});


// 커뮤 수정 내용 확인
const popupForm = document.getElementById("popupForm");
const Title = document.getElementById("Title");
const cCinputContent = document.getElementById("cCinputContent");

popupForm.addEventListener("submit", e => {

  if(cCinputContent.value == ""){
    alert("내용이 비어있습니다.")
    e.preventDefault();
    return;
  }
});





