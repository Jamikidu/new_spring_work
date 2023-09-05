package supul.control;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import supul.model.Reservation;
import supul.model.RoomTheme;
import supul.service.EmailService;
import supul.service.ReserveMapper;
import jakarta.annotation.Resource;

@Controller
public class ReserveController {
	
	@Resource
	ReserveMapper mapper;
	
	@Autowired
    private EmailService emailService; // EmailService 주입
	
	// 이메일을 보내는 예시
    @RequestMapping("/sendEmail")
    public String sendEmail(Model model) {
        String to = "kangjh1994@gmail.com"; // 수신자 이메일 주소
        String subject = "수풀입니다";
        String text = "이메일 내용입니다.";

        emailService.sendEmail(to, subject, text); // 이메일 보내기

        model.addAttribute("msg", "이메일이 성공적으로 전송되었습니다.");
        model.addAttribute("goUrl","/");
        return "alert"; // 이메일 전송 후 보여줄 뷰 페이지
    }
	
	@RequestMapping("/reservation")
	String themes(Model mm, RoomTheme rt){
		System.out.println("예약창 진입");
		System.out.println("초기 rt값 => "+ rt);
		
		mm.addAttribute("reserveData",rt);
		mm.addAttribute("reserveExist",mapper.chkrvstatus(rt));
		return "themes";
	} 
	
	//예약시간 눌렀을때
	@RequestMapping("/reservation/OK")
	String reservation_OK(Model mm,
			@RequestParam(value="picktime")LocalTime real,
			RoomTheme theme,
			Reservation rv) {
		System.out.println("reservation_OK() 진입");
		
		LocalTime rvtime = real;

		System.out.println("theme 초기값 => "+theme);
		
		//예약번호 생성을 위한 포맷작업
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String datenum = (String)theme.getDate().format(formatter);
		
		System.out.println("datenum:" +datenum);

		Random ran = new Random();
		// 중복 없으면 예약번호 생성 아니면 재생성
		while(true) {
			int i = ran.nextInt(1, 10000);
			
			//String rvnum = datenum+Integer.toString(i);
			String rvnum = datenum+String.format("%04d", i); //int i 5여도 0005 로 나오게 변환
			//System.out.println("중복처리 전 rvnum: "+rvnum);
			int cnt = mapper.chkrvnum(rvnum);
			if(cnt==0) {
				//System.out.println("중복처리 후 rvnum: "+rvnum);
				rv.setRv_id(rvnum);
				break;
			}
		}
		
		rv.setDate(theme.getDate());
		rv.setTime(rvtime);
		rv.setRv_date(LocalDateTime.now());

		rv.setRv_people(theme.getPeople());
		rv.setRv_price(theme.getRv_price());
		rv.setThemeName(theme.getTitle());
		
		
		System.out.println("rv: "+rv);
		System.out.println(real);
		mapper.reserve(rv);
		String Msg = real+" 시간 예약 완료!";
		mm.addAttribute("msg", Msg);
		mm.addAttribute("goUrl", "/");
		
		return "alert";
	}
	
	//예약확인
	@GetMapping("checkreservation")
	String checkreservation() {
		return "checkreservation";
	}
	
	//확인처리
	@PostMapping("checkreservation")
	String checkreservationReg(Model mm,
			Reservation rv
			) {
		System.out.println("set 전 rv => "+ rv);

//		mapper.allreserve(); //모든 예약 보기
//		System.out.println("mapper.allrv(): "+ mapper.allreserve());
		
		System.out.println("set 후 rv: "+rv);
		Reservation rvDTO = mapper.confirmreserve(rv);
		System.out.println("mapper결과: "+ rvDTO);
		
		String Msg = "입력하신 예약 정보가 없습니다.";
		mm.addAttribute("msg", Msg);
		mm.addAttribute("goUrl", "checkreservation");
		
		if(rvDTO!=null) {
			
			mm.addAttribute("rvData", rvDTO);
			//mm.addAttribute("goUrl", "myrvinfo");
			System.out.println("mm 확인2: "+ mm);
			return "myrvinfo";
		}
		
		
		return "alert";
	}
	
	//예약취소
	@RequestMapping("/canclereservation")
	String canclereservation(Model mm,
			Reservation rv) {// 파라미터값이 매개변수랑 이름이 똑같으면 알아서 들어감
		
		System.out.println("rv:" +rv);
		mm.addAttribute("msg", "예약 취소 실패.. ㅠㅠ");
		mm.addAttribute("goUrl", "checkreservation");
		
		Reservation rvDTO = mapper.confirmreserve(rv);
		
		System.out.println("rvDTO:"+rvDTO);
		int res = mapper.canclereserve(rvDTO);
		if(res>0) {
			mm.addAttribute("msg", "예약 취소 성공!!!");
			mm.addAttribute("goUrl", "/");
			return "alert";
		}
		return "alert";
	}
}
