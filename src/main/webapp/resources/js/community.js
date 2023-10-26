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
const localSelect = document.getElementById("localSelect");

localSelect.addEventListener('change', () => {

  const areaCode = localSelect.options[localSelect.selectedIndex].value;

  fetch("/community/selectLocal?areaCode=" + areaCode)
  .then(resp => resp.json())
  .then(list => {

    const contentContainer = document.getElementById(community-peopleComment-container);
    contentContainer.innerHTML = "";

    for(var i in list) {
      
      const RSection = document.createElement("div");
      RSection.classList.add("repeatSection");

      const peopleImgSec = document.createElement("div");
      peopleImgSec.classList.add("com-peopleImg-sec");

      const peopleImg = document.createElement("img");
      peopleImg.classList.add("com-peopleImg");

      if(!list[i].profileImage) {
        peopleImg.src = "/resources/img/common/main/프로필아이콘.png";
      } else {
        peopleImg.src = list[i].profileImage;
      }

      peopleImgSec.append(peopleImg);

      const PCSection = document.createElement("div");
      PCSection.classList.add("com-peopleComment-sec");

      const PCTSection = document.createElement("div");
      PCTSection.classList.add("com-peopleComment-top-sec");

      const PCDiv1 = document.createElement("div");
      PCDiv1.classList.add("PCDiv1");
      PCDiv1.innerText = list[i].communityTitle;

      const PCDiv2 = document.createElement("div");
      PCDiv2.classList.add("PCDiv2");

      const PCDiv3 = document.createElement("div");
      PCDiv3.classList.add("PCDiv3");
      PCDiv3.innerText = "조회수" + list[i].readCount;

      const PCDiv4 = document.createElement("div");
      PCDiv4.classList.add("PCDiv4");
      PCDiv4.innerText = "작성인" + list[i].nickName;

      const PCDiv5 = document.createElement("div");
      PCDiv5.classList.add("PCDiv5");
      PCDiv5.innerText = "날짜" + list[i].createDt;

      const PCBSection = document.createElement("div");
      PCBSection.classList.add("com-peopleComment-bot-sec");
      PCBSection.innerText = list[i].communityContent;

      PCSection.append(PCTSection, PCBSection);

      PCTSection.append(PCDiv1, PCDiv2, PCDiv3, PCDiv4, PCDiv5);

      RSection.append(PCSection, PCTSection);

    }



  })
  .catch(err => console.log(err));
});