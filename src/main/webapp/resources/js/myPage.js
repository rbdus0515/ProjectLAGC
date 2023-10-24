


// 공유 버튼 모달
const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const share = document.getElementsByClassName('share-button');
const closeBtnPopup = document.getElementById('closeBtnPopup');


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
  
   closeBtnPopup.addEventListener('click', () => {
   	modal.classList.remove('show');
  });

  // 삭제 alerts
  const planBox = document.querySelector('.my-plan-1');
  const deleteBtn = document.querySelectorAll('.delete-button');

    for(let i = 0; i < deleteBtn.length; i++){
      deleteBtn[i].addEventListener('click', () => {

        var delConfirm = window.confirm("삭제하시겠습니까?");
  
        if(delConfirm == true) {
          delete(planBox)
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

 const moveSlide = function(num){
   slideBox.style.transform = `translateX(${-num * 475}px)`;
   currentIndex = num;
}

prev.addEventListener('click', ()=>{
  if(currentIndex !== 0){
      moveSlide(currentIndex -1)
  }
})

next.addEventListener('click', ()=>{
  if(currentIndex !== slideLangth -1){
      moveSlide(currentIndex +1) 
  } else {
  	moveSlide(currentIndex = 0)
  }
  
})

