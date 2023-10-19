const testContent = document.getElementById('testContent');
const modalContainerPopup = document.getElementById('modalContainerPopup');
const closeBtnPopup = document.getElementById('closeBtnPopup');

testContent.addEventListener('click', () => {
  modalContainerPopup.classList.remove('hidden');
});

closeBtnPopup.addEventListener('click', () => {
  modalContainerPopup.classList.add('hidden');
});
