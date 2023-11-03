// 공유 버튼 모달
const modal = document.querySelector('.modal');
const share = document.getElementsByClassName('share-button');
const closeShare = document.getElementById('closeBtnPopupShare');


for (let i = 0; i < share.length; i++) {
  share[i].addEventListener('click', () => {
    modal.classList.toggle('show');

  });

}

modal.addEventListener('click', (event) => {
  if (event.target === modal) {
    modal.classList.toggle('show');

    if (!modal.classList.contains('show')) {
      body.style.overflow = 'auto';
    }
  }
});

closeShare.addEventListener('click', () => {
  modal.classList.remove('show');
});



const planBox = document.querySelector('.my-plan-1');
const deleteBtn = document.querySelectorAll('.delete-button');
const myPlanHidden = document.getElementsByClassName("myPlanHidden")

for (let i = 0; i < deleteBtn.length; i++) {

  const myPlanNo = myPlanHidden[i].value
  let myPlan = document.getElementById(`myPlan[${myPlanNo}]`)

  deleteBtn[i].addEventListener('click', () => {

    var delConfirm = window.confirm("삭제하시겠습니까?");

    if (delConfirm) {

      fetch("/myPage/deleteMyPlan?myPlanNo=" + myPlanNo)
        .then(resp => resp.text())
        .then(count => {

          if (count > 0) {
            alert("일정이 삭제되었습니다.")
            myPlan.remove();
          }


        })

    }
  })

}

const replyDelete = document.getElementsByClassName("comment-delete")
const comment = document.getElementsByClassName("comment")
const replyNo = document.getElementsByClassName("replyNo")

for (var i = 0; i < comment.length; i++) {

  const tempNo = replyNo[i].value

  let reply = document.getElementById(`reply[${tempNo}]`)

  
  replyDelete[i].addEventListener("click", () => {

    if(confirm("삭제하시겠습니까?")){

      fetch("/myPage/replyDelete?replyNo=" + tempNo)
        .then(resp => resp.text())
        .then(count => {
  
          if (count > 0) {
            alert("후기가 삭제되었습니다.")
            reply.remove();
          }
        })

      } else {

        alert("삭제를 취소했습니다.");

      } 
  })
}






// 좋아요 슬라이드
const prev = document.querySelector('.left-arrow');
const next = document.querySelector('.right-arrow');
const slideBox = document.querySelector('.slideBox');
const slide = document.querySelectorAll('.like-list-1');
const slideLangth = slide.length
let currentIndex = 0;

const moveSlide = function (num) {
  slideBox.style.transform = `translateX(${-num * 475}px)`;
  currentIndex = num;
}

prev.addEventListener('click', () => {
  if (currentIndex !== 0) {
    moveSlide(currentIndex - 1)
  }
})

next.addEventListener('click', () => {
  if (currentIndex !== slideLangth - 1) {
    moveSlide(currentIndex + 1)
  } else {
    moveSlide(currentIndex = 0)
  }

})



const qnaContainer = document.getElementsByClassName("qnaContainer");
const askContentModal = document.getElementById("askContentModal");
const createDate = document.getElementById("createDate")
const QNATitle = document.getElementById("QNATitle")
const whatPeopleAsk = document.getElementById("whatPeopleAsk");
const answerArea = document.getElementById("answerArea")

const qna = document.getElementsByClassName("qna");

for (var i = 0; i < qnaContainer.length; i++) {

  const tempNum = qna[i].value

  qnaContainer[i].addEventListener("click", () => {

    askContentModal.classList.remove('hidden');

    fetch("/myPage/selectQNA?qnaNo=" + tempNum)
      .then(resp => resp.json())
      .then(data => {

        createDate.innerText = data.createDate;
        QNATitle.innerText = data.qnatitle;
        whatPeopleAsk.innerText = data.qnacontent;
        answerArea.innerText = data.qnaanswer;

      })

  })

}

const askCloseBtn = document.getElementById("askCloseBtn");

askCloseBtn.addEventListener('click', () => {
  askContentModal.classList.add('hidden');
});

