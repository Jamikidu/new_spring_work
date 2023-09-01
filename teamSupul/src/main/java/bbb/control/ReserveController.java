package bbb.control;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbb.model.Reservation;
import bbb.model.RoomTheme;
import bbb.service.ReserveMapper;
import jakarta.annotation.Resource;

@Controller
public class ReserveController {
	
	@Resource
	ReserveMapper mapper;

	@RequestMapping("/reservation")
	String themes(Model mm, RoomTheme rt) {
		System.out.println("reservation() 진입");
		System.out.println(rt);
		
		//Map<List<RoomTheme>, Integer> a = new HashMap<>();
		
		
		
	
		mm.addAttribute("reserveData",rt);
		return "themes";
	}
	
	@RequestMapping("/reservation/OK")
	String reservation_OK(Model mm,
			@RequestParam(value="realtime")LocalDateTime real,
			RoomTheme th,
			Reservation rv) {
		System.out.println("reservation_OK() 진입");
		rv.setRt(th);
		rv.setSpot(th.getSpot());
		rv.setType(th.getType());
		rv.setTitle(th.getTitle());
		rv.setPlaytime(th.getPlaytime());
		rv.setRealt(real);
		System.out.println("rv: "+rv);
		System.out.println(real);
		mapper.reserve(rv);
		String Msg = real+" 시간에 예약이 하고싶어요...";
		mm.addAttribute("msg", Msg);
		
		return "alert";
	}
}
