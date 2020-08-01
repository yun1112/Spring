package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class HelloController {
	@RequestMapping("/hello")
	public String hello(Model model) {//매개변수로 Model타입 객체 전달해서 데이터 공
		model.addAttribute("msg", "안녕하세요");
		return "hello/hello";
		// /WEB-INF/views/hello/hello.jsp
	}
}
