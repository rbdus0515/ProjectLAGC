const test = document.getElementById('test');
const modalContainer = document.getElementById('modalContainer');
const comXIcon = document.getElementById('com-XIcon');

test.addEventListener('click', () => {
  modalContainer.classList.remove('hidden');
});

comXIcon.addEventListener('click', () => {
  modalContainer.classList.add('hidden');
});