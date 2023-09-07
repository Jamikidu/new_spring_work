package supul.control;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import supul.service.EmailService;
import supul.service.ReserveMapper;

@Controller
public class HomeController {
	@Resource
	ReserveMapper mapper;
	
	@Resource
    EmailService emailService; // EmailService 주입
	
    DefaultMessageService messageService;

	public HomeController() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSZYMCZEQJKOHRT", "IB2WZJGDV7GC1WY2JSMA342GLQXMWDNX", "https://api.coolsms.co.kr");
    }
	
	@RequestMapping("/")
	String supulHome(Model mm) throws MessagingException, IOException {
		System.out.println("SUPUL팀 홈");
		
		//emailService.sendMail();
		
        // 템플릿으로 현재 날짜를 전달
        mm.addAttribute("now", LocalDate.now());
		
		return "home";  // views/home.html
	}
	
    @RequestMapping("/sendsms")
    public String sendSMS(Model model) {
        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01025702909");	// 발신자번호
        message.setTo("01051196127");	// 수신자번호
        //message.setText("SUPUL 방탈출 예약 2시간 전입니다.");
        message.setText("○○○님 SUPUL 방탈출 예약 2시간 전입니다.");	//발송문구

        model.addAttribute("msg","SMS 발송실패 ㅠㅠ");
        model.addAttribute("goUrl","/");
        
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
        
        if(response!=null) {
        	model.addAttribute("msg","SMS 발송 성공!!");
        }
        
        
        
        return "alert";
    }
}
