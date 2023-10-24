
function showQNA(value){
    
    fetch("/manager/managingAsk?doneOrYet=" + value)
    .then(response => response.json())
    .then(list => {

        const askContent = document.getElementById("askContent");
        console.log(list)

        askContent.innerHTML = "";

        for(var qna in list){

            const askDetail = document.createElement("div");
            askDetail.classList.add("askDetail");

            const memberContainer = document.createElement("div");
            memberContainer.classList.add("memberContainer")


            const category = document.createElement("div");
            category.classList.add("category")
            
            const email = document.createElement("div");
            email.innerText = "이메일";

            const phone = document.createElement("div");
            phone.innerText = "휴대폰";

            const title = document.createElement("div");
            title.innerText = "제목";

            const member = document.createElement("div");
            member.innerText = "작성자";

            category.append(email, phone, title, member);



            const asker = document.createElement("div");
            asker.classList.add("asker");

            const askerEmail = document.createElement("div");
            askerEmail.classList.add("askerEmail");
            askerEmail.innerHTML = list[qna].memberEmail;
           
            const askerPhone = document.createElement("div");
            askerPhone.classList.add("askerPhone");
            askerPhone.innerHTML = list[qna].memberPhone;
            
            const QNATitle = document.createElement("div");
            QNATitle.classList.add("QNATitle");
            QNATitle.innerHTML = list[qna].qnatitle;

            const askerNickname = document.createElement("div");
            askerNickname.classList.add("askerNickname");
            askerNickname.innerHTML = list[qna].memberNickname;

            asker.append(askerEmail, askerPhone, QNATitle, askerNickname);


            memberContainer.append(category, asker);


            const div = document.createElement("div");

            const whatPeopleAsk = document.createElement("div");
            whatPeopleAsk.classList.add("whatPeopleAsk");
            whatPeopleAsk.innerHTML = list[qna].qnacontent;

            div.append(whatPeopleAsk);


            const form = document.createElement("form")

            console.log(list[qna].answerFlag)

            if(list[qna].answerFlag == "N "){
                form.setAttribute("action", "/manager/insert");
            } else {
                form.setAttribute("action", "/manager/update");
            }

            const hidden = document.createElement("input")
            hidden.setAttribute("type","hidden");
            hidden.setAttribute("value",list[qna].qnano);
            hidden.name = "qnaNo";
            

            const answer = document.createElement("div");
            answer.classList.add("answer");

            const p = document.createElement("p");
            p.innerText = "답변";

            const answerArea = document.createElement("textarea");
            answerArea.classList.add("answerArea");
            answerArea.innerHTML = list[qna].qnaanswer;
            answerArea.name = "answerArea"


            const answerBtn = document.createElement("button");
            answerBtn.classList.add("answerBtn");
            answerBtn.innerText = "답변 제출";
            

            answer.append(p, answerArea, answerBtn);

            form.append(answer, hidden);

            askDetail.append(memberContainer, div, form);

            askContent.append(askDetail)
        }
        
        
        

    })


}

