package kh.semi.project.common.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kh.semi.project.common.model.dao.AjaxDAO;

@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private AjaxDAO dao;
	
	@Autowired
	private JavaMailSender mailsender;
	
	private String fromEmail = "LAGC@gmail.com";
	private String fromUsername = "LAGC";
	
	/** 난수 생성 메서드
     * @return
     */
    public String createAuthKey() {
        String key = "";
        for(int i=0 ; i< 6 ; i++) {
            
            int sel1 = (int)(Math.random() * 3); // 0:숫자 / 1,2:영어
            
            if(sel1 == 0) {
                
                int num = (int)(Math.random() * 10); // 0~9
                key += num;
                
            }else {
                
                char ch = (char)(Math.random() * 26 + 65); // A~Z
                
                int sel2 = (int)(Math.random() * 2); // 0:소문자 / 1:대문자
                
                if(sel2 == 0) {
                    ch = (char)(ch + ('a' - 'A')); // 대문자로 변경
                }
                
                key += ch;
            }
            
        }
        return key;
    }
	
	/** 아이디 중복검사 서비스
	 *
	 */
	@Override
	public int selectId(String memberId) {

		return dao.selectId(memberId);
	}

	/** 닉네임 중복검사 서비스
	 *
	 */
	@Override
	public int selectNickname(String nickname) {
		
		return dao.selectNickname(nickname);
	}

	/** 이메일 인증키 전송 서비스
	 *
	 */
	@Override
	public int sendAuthKey(String memberEmail) {

		String authKey = createAuthKey();
		
		try {
		
		//인증메일 보내기
        MimeMessage mail = mailsender.createMimeMessage();
        
        // 제목
        String subject = "[LAGC_Project] 이메일 확인 인증코드";
        
        // 문자 인코딩
        String charset = "UTF-8";
        
        // 메일 내용
        String mailContent 
            = "<p>LAGC Project 이메일 확인 인증코드입니다.</p>"
            + "<h3 style='color:blue'>" + authKey + "</h3>";
        
        
        // 송신자(보내는 사람) 지정
        mail.setFrom(new InternetAddress(fromEmail, fromUsername));
        
        // 수신자(받는사람) 지정
        mail.addRecipient(Message.RecipientType.TO, new InternetAddress(memberEmail));
        
        // 이메일 제목 세팅
        mail.setSubject(subject, charset);
        
        // 내용 세팅
        mail.setText(mailContent, charset, "html"); //"html" 추가 시 HTML 태그가 해석됨
        
        mailsender.send(mail);
        
    } catch (Exception e) {
    	
        e.printStackTrace();
        
        return 0;
    }
    
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("authKey", authKey);
    map.put("memberEmail", memberEmail);
    
    int result = dao.updateAuthKey(map);
    
    if(result == 0) {
    	result = dao.insertAuthKey(map);
    }

    return result;

	}
	
	/** 이메일 인증키 확인 서비스 
	 *
	 */
	@Override
	public int checkAuthKey(String inputKey, String memberEmail) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("inputKey", inputKey);
	    map.put("memberEmail", memberEmail);
		
	    return dao.checkAuthKey(map);
	}

}
