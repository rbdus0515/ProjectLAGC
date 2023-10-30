const placeSec = document.getElementsByClassName('placeSec');

const modalContainerPopup = document.getElementById('modalContainerPopup');
const closeBtnPopup = document.getElementById('closeBtnPopup');

const contentNo = document.getElementsByClassName("contentNo");
const checkbox = document.getElementById("checkbox");
const likeCount = document.getElementById("likeCount");
const travelName = document.getElementById("travelName")
const webSite = document.getElementById("webSite")
const travelImg = document.getElementById("travelImg")
const explain = document.getElementById("explain")
const comment1 = document.getElementById("comment1")
const comment2 = document.getElementById("comment2")
const comment3 = document.getElementById("comment3")


let temp = 0;
let temp2 = 0;

for(var i = 0 ; i < placeSec.length ; i++){
  
  const tempNum = contentNo[i].value

  placeSec[i].addEventListener('click', () => {
    
    temp2 = tempNum;

    modalContainerPopup.classList.remove('hidden');
    
    likeCount.innerHTML = "";
  
    fetch("/content/like?contentNo=" + tempNum)
      .then(response => response.json()) 
      .then(data => {
        
        travelName.innerText = data.TRAVEL_NAME;
        webSite.setAttribute("href", data.PLACE_URL);
        travelImg.setAttribute("src", data.CONTENT_IMG);
        explain.innerHTML = data.PLACE_INFO;
        comment1.innerHTML = data.reply0
        comment2.innerHTML = data.reply1
        comment3.innerHTML = data.reply2


        likeCount.innerHTML += data.likeCount;

        temp = likeCount.innerText;
  
        if (data.likeYesOrNo == -1) { 
          console.log("좋아요 처리 실패");
          return;
        } else if (data.likeYesOrNo == 1) {
          checkbox.checked = true;
        } else {
          checkbox.checked = false;
        }
        
      })
      



  });

}

checkbox.addEventListener("click", () => {

  temp = parseInt(temp);

  if (memberNo == "") {

    alert("로그인 후 이용해주세요");
    checkbox.checked = false;
    return;

  } else {
    fetch("/member/like?contentNo=" + temp2)
      .then(response => response.text())
      .then(count => {

        if (count > 0) {
          likeCount.innerText = temp + 1;
          temp = likeCount.innerText;
          return;
          
        } else {
          likeCount.innerText = temp - 1;
          temp = likeCount.innerText;
          return;

        }
      })

  }

})

closeBtnPopup.addEventListener('click', () => {
  modalContainerPopup.classList.add('hidden');
});

const replyBtn = document.getElementById("replyBtn");
const reply = document.getElementById("reply")

replyBtn.addEventListener("click", () => {

  if (memberNo == "") {
    alert("로그인 후 이용해주세요");
    return;

  } else {

    fetch("/content/insert?contentNo=" + temp2 + "&reply=" + reply.value)
      .then(response => response.json())
      .then(replys => {

        comment1.innerHTML = ""
        comment2.innerHTML = ""
        comment3.innerHTML = ""

        if(replys.reply0 != null){
          comment1.innerHTML = replys.reply0
        } else{
          comment1.innerHTML = "작성된 후기가 없습니다."
        }

        if(replys.reply1 != null){
          comment2.innerHTML = replys.reply1
        } else{
          comment2.innerHTML = "작성된 후기가 없습니다."
        }

        if(replys.reply2 != null){
          comment3.innerHTML = replys.reply2
        } else{
          comment3.innerHTML = "작성된 후기가 없습니다."
        }

       
      })

      reply.value = "";
    }
    
    
})