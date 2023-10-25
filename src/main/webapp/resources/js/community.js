const test = document.getElementById('test');
const modalContainer = document.getElementById('modalContainer');
const comXIcon = document.getElementById('com-XIcon');

test.addEventListener('click', () => {
  modalContainer.classList.remove('hidden');
});

comXIcon.addEventListener('click', () => {
  modalContainer.classList.add('hidden');
});

// 커뮤니티 메인 ajax
document.addEventListener('change',(value) => {

  fetch("/community?areaCode=" + value)
  .then(resp => resp.json())
  .then(list => {
    const contentContainer = document.getElementById(community-peopleComment-container);
    contentContainer.innerHTML = "";

    for(i in list) {

      

    }



  })
  .catch(err => console.log(err));
});