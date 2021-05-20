package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03/exam03";
	}

	@RequestMapping("/calcPrice")
	public String calcPrice(Integer price1, Integer price2, Integer price3) {
		int sumPrice = price1 + price2 + price3;
		application.setAttribute("nonTaxPrice", sumPrice);
		int inTaxPrice = (int) (sumPrice * 1.1);
		application.setAttribute("inTaxPrice", inTaxPrice);

		return "exam03/exam03Result";
	}
}
