package com.example.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/shop")
public class ShoppingCartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index(Model model) {

		Item item1 = new Item();
		item1.setName("手帳ノート");
		item1.setPrice(1000);
		Item item2 = new Item();
		item2.setName("文房具セット");
		item2.setPrice(1500);
		Item item3 = new Item();
		item3.setName("ファイル");
		item3.setPrice(2000);

		Map<Integer, Item> itemMap = new LinkedHashMap<>();
		itemMap.put(1, item1);
		itemMap.put(2, item2);
		itemMap.put(3, item3);

		application.setAttribute("itemInSaleMap", itemMap);

		List<Item> itemInCartList = (List<Item>) session.getAttribute("itemInCartList");
		if (itemInCartList == null) {
			itemInCartList = new LinkedList<>();
			session.setAttribute("itemInCartList", itemInCartList);
		}
		int totalPrice = 0;
		for (Item item : itemInCartList) {
			totalPrice += item.getPrice();
		}
		model.addAttribute("totalPrice", totalPrice);

		return "exam06/itemAndCart";

	}

	@RequestMapping("/inCart")
	public String inCart(int inItemIndex, Model model) {

		System.out.println("inItemIndex: " + inItemIndex);

		Map<Integer, Item> itemMap = (Map<Integer, Item>) application.getAttribute("itemInSaleMap");
		System.out.println(itemMap);

		List<Item> itemInCartList = (List<Item>) session.getAttribute("itemInCartList");

		itemInCartList.add(itemMap.get(inItemIndex));

		session.setAttribute("itemInCartList", itemInCartList);

		return "redirect:/shop";

	}

	@RequestMapping("/delete")
	public String delete(int deleteItemIndex, Model model) {

		List<Item> itemInCartList = (List<Item>) session.getAttribute("itemInCartList");
		itemInCartList.remove(deleteItemIndex);
		session.setAttribute("itemInCartList", itemInCartList);

		return "redirect:/shop";
	}
}
