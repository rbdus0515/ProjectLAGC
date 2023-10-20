


// 공유 버튼 모달
const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const share = document.getElementsByClassName('share-button');
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

  const deleteBtn = document.querySelector('.delete-button');
    deleteBtn.addEventListener('click', () => {

      var delConfirm = window.confirm("삭제하시겠습니까?");
    })



