package com.example.form;

import javax.validation.constraints.NotBlank;

public class NameForm {

	@NotBlank(message = "検索したい名前を入力してください")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NameForm [name=" + name + "]";
	}

}
