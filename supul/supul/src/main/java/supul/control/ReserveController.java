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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import supul.model.Reservation;
import supul.model.RoomTheme;
import supul.service.ReserveMapper;
import jakarta.annotation.Resource;

@Controller
public class ReserveController {
	
	@Resource
	ReserveMapper mapper;
	
	Random ran = new Random();
	

	@RequestMapping("/reservation")
	String themes(Model mm, RoomTheme rt) {
		System.out.println("reservation() 진입");
		System.out.println(rt);
		
//		mapper.findDate(rt);
//		System.out.println("mapper.findDate(rt): " + mapper.findDate(rt));
//		Map<List<RoomTheme>, Integer> a = new HashMap<>();
		
		
		
	
		mm.addAttribute("reserveData",rt);
		return "themes";
	}
	
	//예약시간 눌렀을때
	@RequestMapping("/reservation/OK")
	String reservation_OK(Model mm,
			@RequestParam(value="realtime")LocalDateTime real,
			RoomTheme th,
			Reservation rv) {
		System.out.println("reservation_OK() 진입");
		
		
		//시간 받아온 값을 db에 따로 저장하기 위해서 날짜와 시간으로 나눠줌
		LocalDate rvdate = real.toLocalDate();	
		LocalTime rvtime = real.toLocalTime();
		//System.out.println("rvdate:"+rvdate);
		//System.out.println("rvtime:"+rvtime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String datenum = (String)rvdate.format(formatter);
		
		//SimpleDateFormat rvnumFormat = new SimpleDateFormat("yyMMdd"); 
		//String datenum = rvnumFormat.format(rvdate);
		System.out.println("datenum:" +datenum);

		
		// 중복 없으면 0 중복있으면 1 여러개면 2이상
		while(true) {
			
			int i = ran.nextInt(1, 1000);
			
			//String rvnum = datenum+Integer.toString(i);
			String rvnum = datenum+String.format("%03d", i);
			//System.out.println("중복처리 전 rvnum: "+rvnum);
			int cnt = mapper.chkrvnum(rvnum);
			if(cnt==0) {

				//System.out.println("중복처리 후 rvnum: "+rvnum);
				rv.setRvnum(rvnum);
				break;
			}
			
		}
		
		rv.setRt(th);
		rv.setSpot(th.getSpot());
		rv.setType(th.getType());
		rv.setTitle(th.getTitle());
		rv.setPlaytime(th.getPlaytime());
		
		rv.setRvdate(rvdate);
		rv.setRvtime(rvtime);
		
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
			@RequestParam(value="id")String id,
			@RequestParam(value="pname")String pname,
			Reservation rv
			) {
		rv.setId(id);
		rv.setPname(pname);

//		mapper.allreserve(); 모든 예약 보기
//		System.out.println("mapper.allrv(): "+ mapper.allreserve());
		
		System.out.println("rv: "+rv);
		Reservation rvDTO = mapper.chkreserve(rv);
		System.out.println("mapper결과: "+rvDTO);
		
		String Msg = "입력하신 예약 정보가 없습니다.";
		mm.addAttribute("msg", Msg);
		mm.addAttribute("goUrl", "checkreservation");
		
		if(rvDTO!=null) {
			Msg = "예약정보 확인 완료";
			mm.addAttribute("rvData", mapper.chkreserve(rv));
			mm.addAttribute("msg", Msg);
			//mm.addAttribute("goUrl", "myrvinfo");
			System.out.println("mm 확인2: "+ mm);
			return "myrvinfo";
		}
		
		
		return "alert";
	}
	
	@RequestMapping("canclereservation")
	String canclereservation(Model mm,
			Reservation rv) {
		
		mm.addAttribute("msg", "예약 취소 실패.. ㅠㅠ");
		mm.addAttribute("goUrl", "/");
		
		Reservation rvDTO = mapper.chkreserve(rv);
		//System.out.println("rvDTO:"+rvDTO);
		int res = mapper.canclereserve(rvDTO);
		if(res>0) {
			mm.addAttribute("msg", "예약 취소 성공!!!");
			return "alert";
		}
		return "alert";
	}
}
