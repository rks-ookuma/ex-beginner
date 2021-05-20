package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

	@Autowired
	private HttpSession session;

	@RequestMapping("")
	public String index() {
		return "exam02";
	}

	@RequestMapping("/receive")
	public String receive(String num1, String num2, Model model) {
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		int result = Integer.parseInt(num1) + Integer.parseInt(num2);
		session.setAttribute("result", result);

		return "exam02Result";
	}

	@RequestMapping("/toPage")
	public String toPage() {
		return "exam02Result2";
	}
}
