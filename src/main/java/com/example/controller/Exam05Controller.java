package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

	@RequestMapping("")
	public String index() {
		return "exam05/exam05";
	}

}
