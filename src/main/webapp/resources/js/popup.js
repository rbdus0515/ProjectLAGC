const content = document.getElementsByClassName('content');

const modalContainerPopup = document.getElementById('modalContainerPopup');
const closeBtnPopup = document.getElementById('closeBtnPopup');

const contentNo = document.getElementsByClassName("contentNo");
const checkbox = document.getElementById("checkbox");
const likeCount = document.getElementById("likeCount");
let temp = 0;
let temp2 = 0;

for(var i = 0 ; i < content.length ; i++){
  
  const tempNum = contentNo[i].value

  content[i].addEventListener('click', () => {
    
    temp2 = tempNum;

    modalContainerPopup.classList.remove('hidden');
  
    likeCount.innerHTML = "";
  
    fetch("/content/like?contentNo=" + tempNum)
      .then(response => response.json()) 
      .then(data => {
        
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

