//----------------------------------------------------

// ������ �̹��� �߰�/����/����
const profileImage = document.getElementById("profileImage"); // img �±�
const imageInput = document.getElementById("imageInput"); // input �±�
const deleteImage = document.getElementById("deleteImage"); // x��ư


let initCheck; // �ʱ� ������ �̹��� ���¸� �����ϴ� ����
                // false == �⺻ �̹���,  true == ���� ���ε� �̹���

let deleteCheck = -1; 
// ������ �̹����� ���� ���ε� �ǰų� ���� �Ǿ����� ��Ÿ���� ����
// -1 == �ʱⰪ ,  0 == ������ ����(x��ư),  1 == �� �̹��� ���ε�


let originalImage; // �ʱ� ������ �̹��� ���� ��� ����

if(imageInput != null){ // ȭ�鿡 imageInput�� ���� ��� ( if ���� ���ص� �Ǳ� �� ) 

    // ������ �̹����� ��µǴ� img�±��� src �Ӽ��� ����
    originalImage = profileImage.getAttribute("src"); 


    // ȸ�� ������ ȭ�� ���� �� 
    // ���� ȸ���� ������ �̹��� ���¸� Ȯ��
    if(profileImage.getAttribute("src") == "/resources/images/user.png"){
        // �⺻ �̹����� ���
        initCheck = false;
    }else{
        initCheck = true;
    }
    



    // change �̺�Ʈ : ���� ������ ��
    // - input type="file", "checkbox", "radio" ���� ���� ���
    // - text/number ���� ��� ����
    //   -> �� �� input�� �Է� �� ��Ŀ���� �Ҿ��� �� 
    //      ���� ���� �ٸ��� change �̺�Ʈ �߻�

    imageInput.addEventListener("change", e => {

        // 2MB�� �ִ� ũ�� ���� 
        const maxSize = 1 * 1024 * 1024 * 2; // ���� �ִ� ũ�� ����(����Ʈ ����)

        console.log(e.target); // input
        console.log(e.target.value); // ���ε�� ���� ���
        console.log(e.target.files); // ���ε�� ������ ������ ��� �迭

        const file = e.target.files[0]; // ���ε��� ������ ������ ��� ��ü


        // ������ �ѹ� ������ �� ������� �� ( file�� undefined�� �ȴ� ) 
        if(file == undefined){ 
            console.log("���� ������ ��ҵ�");
            deleteCheck = -1; // ��� == ���� ���� == �ʱ����

            // ��� �� ���� ������ �̹����� ���� ( ���� �̹������� ����Ǵ°� ���� �ϰڴٴ°��� ) 
            profileImage.setAttribute("src", originalImage);

            return;
        }

        if( file.size > maxSize){ // ���õ� ������ ũ�Ⱑ �ִ� ũ�⸦ �ʰ��� ���
            alert("2MB ������ �̹����� �������ּ���.");
            imageInput.value = ""; 
            // input type="file" �±׿� ������ �� �ִ� value�� "" (��ĭ) ���̴�!
            deleteCheck = -1; // ��� == ���� ���� == �ʱ����

            // ���� ������ �̹����� ����
            profileImage.setAttribute("src", originalImage);

            return;
        }

	
        // JS���� ������ �д� ��ü
        // - ������ �а� Ŭ���̾�Ʈ ��ǻ�Ϳ� ������ ������ �� ���� 
        const reader = new FileReader();

        reader.readAsDataURL(file);
        // �Ű������� �ۼ��� ������ �о ���� ��
        // ������ ��Ÿ���� URL�� result �Ӽ����� ���� �� �ְ� ��.

        // �� �о��� ��
        reader.onload = e => {
            //console.log(e.target);
            console.log(e.target.result); // ���� ������ URL 
            /* �����ڵ������� Application�ǿ��� Frames > top > images �ȿ��� Ȯ�ΰ��� */

            const url = e.target.result;

            // �������̹���(img) �±׿� src �Ӽ����� �߰�
            profileImage.setAttribute("src", url);

            deleteCheck = 1;
        }
    });


    // x��ư Ŭ�� ��
    deleteImage.addEventListener('click', () => {
        imageInput.value = ""; // input type="file"�� value ����

        profileImage.setAttribute("src", "/resources/images/user.png");
        // ������ �̹����� �⺻ �̹����� ����

        deleteCheck = 0;
    });


    // #profileFrm�� ���� �Ǿ��� ��
    document.getElementById("profileFrm").addEventListener("submit", e => {

        // initCheck
        // �ʱ� ������ �̹��� ���¸� �����ϴ� ����
        // false == �⺻ �̹���,  true == ���� ���ε� �̹���

        // deleteCheck
        // ������ �̹����� ���� ���ε� �ǰų� ���� �Ǿ����� ��Ÿ���� ����
        // -1 == �ʱⰪ ,  0 == ������ ����(x��ư),  1 == �� �̹��� ���ε�

        let flag = true; // �����ϸ� �ȵǴ� ����� �ʱⰪ �÷��� true�� ����

        // ���� ������ �̹����� �����鼭, �� �̹��� ���ε带 �ߴ� -> ó������ �̹��� �߰�
        if(!initCheck && deleteCheck == 1)  flag = false;

        // ���� ������ �̹����� �����鼭, �� �̹��� ���ε带 �ߴ� -> �� �̹����� ����
        if(initCheck && deleteCheck == 1)   flag = false;
        
        // ���� ������ �̹����� �����鼭, ������ ���� ��ư�� ������ -> ����
        if(initCheck && deleteCheck == 0)   flag = false;

        
        if(flag){ // flag == true -> �����ϸ� �ȵǴ� ���
            e.preventDefault(); // form �⺻ �̺�Ʈ ����
            alert("�̹��� ���� �� Ŭ���ϼ���");
        }

	    return true;
    });




}