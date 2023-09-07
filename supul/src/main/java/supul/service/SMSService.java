package supul.service;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;


@Service
public class SMSService {

    DefaultMessageService messageService;

	public SMSService() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSZYMCZEQJKOHRT", "IB2WZJGDV7GC1WY2JSMA342GLQXMWDNX", "https://api.coolsms.co.kr");
    }
	
	//SMS 보내기
	public void sendSMS(Model model) {
		Message message = new Message();
		// 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
		message.setFrom("01025702909"); // 발신자번호
		message.setTo("01051196127"); // 수신자번호
		// message.setText("SUPUL 방탈출 예약 2시간 전입니다.");
		message.setText("○○○님 SUPUL 방탈출 예약 2시간 전입니다."); // 발송문구

		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
		System.out.println(response);

		if (response != null) {
			System.out.println("SMS 발송 성공!!");
		}
	}
}
