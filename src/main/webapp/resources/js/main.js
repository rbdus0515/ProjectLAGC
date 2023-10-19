const infoBtn = document.getElementById('infoBtn');
const closeBtn = document.getElementById('closeBtn');
const modal = document.getElementById('modalContainer');

infoBtn.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

closeBtn.addEventListener('click', () => {
  modal.classList.add('hidden');
});

