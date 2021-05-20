package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam04/exam04";
	}

	@RequestMapping("/receiveUserInfo")
	public String receiveUserInfo(@Validated UserForm userForm, BindingResult result, User user, Model model) {
		if (result.hasErrors()) {
			return "exam04/exam04";
		}
		BeanUtils.copyProperties(userForm, user);
		model.addAttribute("user", user);

		return "exam04/exam04Result";
	}

}
