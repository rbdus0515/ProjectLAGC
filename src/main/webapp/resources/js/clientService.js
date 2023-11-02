const qnaFrm = document.getElementById("qnaFrm");

const qnaTitle = document.getElementById("qnaTitle")
const askText = document.getElementById("askText")

qnaFrm.addEventListener("submit", e => {

	if (qnaTitle.value.trim() == "") {
        alert("제목을 입력해주세요");
        qnaTitle.focus();
        e.preventDefault();
        return;
    }

	if (askText.value.trim() == "") {
        alert("문의 사항을 입력해주세요");
        askText.focus();
        e.preventDefault();
        return;
    }

})

const noUse = document.getElementsByClassName("noUse")

for(var i = 0 ; i <noUse.length ; i ++){
	
	noUse[i].addEventListener("click", () => {
	
		alert("로그인 후 이용해주세요")
	
	})

}