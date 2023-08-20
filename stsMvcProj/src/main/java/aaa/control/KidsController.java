package aaa.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.kids.Group;
import aaa.kids.Kids;


@Controller
@RequestMapping("request/kids")
public class KidsController {

	@GetMapping
	String kidsForm() {
		return "kids/kidsForm";
	}
	
	@PostMapping
	String kidsClass(Group gr) {
		for(Kids kid : gr.karr) {
			kid.getRank(gr.karr);
		}
		Collections.sort(gr.karr);
		System.out.println(gr);
		return "kids/kidsClass";
	}
	
}
