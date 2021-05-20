package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.form.NameForm;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

	@ModelAttribute
	public NameForm setUpForm() {
		return new NameForm();
	}

	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam05/exam05";
	}

	@RequestMapping("/searchName")
	public String searchName(@Validated NameForm nameForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "exam05/exam05";
		}
		List<Member> members = repository.findByName(nameForm.getName());
		model.addAttribute("memberList", members);

		return "exam05/exam05Result";
	}
}
