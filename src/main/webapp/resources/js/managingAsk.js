const doneOrYet = document.querySelectorAll("input[name=doneOrYet]");

const askerEmail = document.getElementById("askerEmail");
const askerPhone = document.getElementById("askerPhone");
const QNATitle = document.getElementById("QNATitle");
const askerNickname = document.getElementById("askerNickname");
const whatPeopleAsk = document.getElementsByClassName("whatPeopleAsk");
const answerBtn = document.getElementsByClassName("answerBtn")
const askDetail = document.getElementsByClassName("askDetail");
const askContainer = document.getElementsByClassName("askContainer");

doneOrYet[0].addEventListener("click", () => {

    askerEmail.innerHTML = "";
    askerPhone.innerHTML = "";
    QNATitle.innerHTML = "";
    askerNickname.innerHTML = "";
    whatPeopleAsk.innerHTML = "";
    answerBtn.innerHTML = "";

    fetch("/manager/managingAsk?doneOrYet=" + doneOrYet[0].value)
    .then(resp => resp.json())
    .then(list => {

        for(var i = 0; i < list.length ; i++){

            const newDiv = document.createElement("div");
            newDiv.classList.add("askContainer");
            newDiv.append(div);

            // askerEmail.innerHTML += `${list[i].memberEmail}`;
            // askerPhone.innerHTML += `${list[i].memberPhone}`;
            // QNATitle.innerHTML += `${list[i].qnatitle}`;
            // askerNickname.innerHTML += `${list[i].memberNickname}`;
            // whatPeopleAsk.innerHTML += `${list[i].qnaContent}`;
            // answerBtn.innerHTML += "답변 제출하기";
        }

    })

});

doneOrYet[1].addEventListener("click", () => {

    askerEmail.innerHTML = "";
    askerPhone.innerHTML = "";
    QNATitle.innerHTML = "";
    askerNickname.innerHTML = "";
    whatPeopleAsk.innerHTML = "";
    answerBtn.innerHTML = "";

    fetch("/manager/managingAsk?doneOrYet=" + doneOrYet[1].value)
    .then(resp => resp.json())
    .then(list => {

        for(var i = 0; i<list.length ; i++){

            askerEmail.innerHTML += `${list[i].memberEmail}`;
            askerPhone.innerHTML += `${list[i].memberPhone}`;
            QNATitle.innerHTML += `${list[i].qnatitle}`;
            askerNickname.innerHTML += `${list[i].memberNickname}`;
            whatPeopleAsk.innerHTML += `${list[i].qnaContent}`;
            answerBtn.innerHTML += "수정하기";
        }

    })

});

