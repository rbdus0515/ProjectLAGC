const modalContainer = document.getElementById('modalContainer');
const comXIcon = document.getElementById('com-XIcon');

comXIcon.addEventListener('click', () => {
  modalContainer.classList.add('hidden');
});

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

      if(list[i].profileImage) {
        peopleImg.src = "/resources/img/common/main/프로필아이콘.png";
      } else {
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
    .then(ccomentList => {

      console.log("ccomentList:: ",ccomentList);

      // ajax 컨테이너
      const ajaxSec = document.getElementById("ajaxSec");
      ajaxSec.innerHTML = "";

      // 모달창 커뮤니티 제목, 컨텐트
      const hCommunityTitle = document.getElementsByClassName("hCommunityTitle");
      const hCommunityContent = document.getElementsByClassName("hCommunityContent");
      const loginMemberNo = document.getElementById("loginMemberNo");
      const hMemberNo = document.getElementsByClassName("hMemberNo");
      
      const comTitleDiv = document.getElementsByClassName("comTitleDiv");
      comTitleDiv.innerHTML = "";





      // for(var i = 0; i < hMemberNo.length; i++) {

      //   const temp = hMemberNo[i].value;

      //   if(temp == loginMemberNo.value){
      //     console.log("게시물 작성한 멤버 no::",temp);
      //     console.log("로그인한 멤버 no::",loginMemberNo.value);
      //     console.log("로그인 멤버임!");
      //   }

      // }

      

      



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
        peopleProfile.setAttribute("src", ccomentList[cc].profileImage);

        // 프로필 이름 부분
        const PBPBSec = document.createElement("div");
        PBPBSec.classList.add("pop-botBox-profileSec-botSec");
        PBPBSec.innerText = ccomentList[cc].memberNickName;

        
      
        // -----------------------------------------------------------

        // 댓글 부분 sec
        const CCommentSec = document.createElement("div");
        CCommentSec.classList.add("pop-botBox-doubleComment-sec");

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

        // 삭제 버튼
        const deleteBtn = document.createElement("button");
        
        // 삭제 버튼 이미지
        const deleteBtnImg = document.createElement("img");
        deleteBtnImg.setAttribute("src", "/resources/img/community/Vector.png");
        deleteBtnImg.classList.add("com-doubleComment-XIcon");

       

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
        deleteBtnSec.append(deleteBtn);
        deleteBtn.append(deleteBtnImg);





      }

    })
    .catch(err => console.log(err));
  }
});