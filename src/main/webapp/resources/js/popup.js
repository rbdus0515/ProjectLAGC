const testContent = document.getElementById('testContent');
const modalContainerPopup = document.getElementById('modalContainerPopup');
const closeBtnPopup = document.getElementById('closeBtnPopup');
const contentNo = document.getElementById("contentNo");
const checkbox = document.getElementById("checkbox");
const likeCount = document.getElementById("likeCount");

testContent.addEventListener('click', () => {
  modalContainerPopup.classList.remove('hidden');

  likeCount.innerHTML = "";

  fetch("/content/like?contentNo=" + contentNo.value)
    .then(response => response.json()) 
    .then(data => {

      console.log(data)

      likeCount.innerHTML += data.likeCount +"개";

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

closeBtnPopup.addEventListener('click', () => {
  modalContainerPopup.classList.add('hidden');
});
