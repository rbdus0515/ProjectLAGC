const infoBtn = document.getElementById('infoBtn');
const closeBtn = document.getElementById('closeBtn');
const modal = document.getElementById('modalContainer');

infoBtn.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

closeBtn.addEventListener('click', () => {
  modal.classList.add('hidden');
});

const btn = document.getElementById("btn")

// btn.addEventListener("click", (e) => {

//   console.log(e.target.textContent);

// })

const recommendBtn = document.getElementsByClassName("recommendBtn")
const chooseCategory = document.getElementById("chooseCategory")
const ageCategory = document.getElementById("ageCategory")
const memberCategory = document.getElementById("memberCategory")
const seasonCategory = document.getElementById("seasonCategory")
const themeCategory = document.getElementById("themeCategory")

const value = {
  "age" : '',
  "member" : '',
  "season" : '',
  "theme" : '',
};

for(var i = 0 ; i < recommendBtn.length ; i ++){


  recommendBtn[i].addEventListener("click", (e) => {

    switch(e.target.value){

      case '20': case '30': case '40': case '50': 
      ageCategory.innerText = "#" + e.target.textContent; 
      value.age = e.target.value;
      break;
      
      case 'solo': case 'friend': case 'couple': case 'family': 
      memberCategory.innerText = "#" + e.target.textContent; 
      value.member = e.target.value;
      break;
      
      case 'spring': case 'summer': case 'autumn': case 'winter': 
      seasonCategory.innerText = "#" + e.target.textContent; 
      value.season = e.target.value;
      break;
      
      case 'nature': case 'downtown': case 'tradition': case 'healing': case 'activity': 
      themeCategory.innerText = "#" + e.target.textContent; 
      value.theme = e.target.value;
      break;
      
    }

    console.log(value)


  }) 


}
