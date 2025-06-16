package com.example.demo.control;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;
import com.example.demo.service.ItemService;

@Controller
public class ItemController {
	
	private ItemService itemService;
	private String noChoiceOption;
	
	public ItemController(ItemService itemService) {
		this.itemService= itemService;
		noChoiceOption = "選択";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	private String[] getCityChoices() {
		String[] cities = itemService.getCities();
		int cityNum = cities.length;
		
		String[] cityChoices = new String[cityNum+1];
		cityChoices[0] = "選択";
		for(int i=0; i<cityNum; i++) {
			cityChoices[i+1] = cities[i];
		}
		return cityChoices;
	}
	
	@GetMapping("/goItemList")
	public String goItemList(Model model) {
		
		ItemForm itemForm = new ItemForm();
		String[] cities = getCityChoices();
		itemForm.setCityChoices(cities);
		itemForm.setCity(noChoiceOption);
		
		model.addAttribute("itemForm", itemForm);
		
		return "hotel-list.html";
	}
	
	@GetMapping("/listChoices")
	public String listChoices(@Validated @ModelAttribute ItemForm itemForm, 
			BindingResult result, @RequestParam("dayOffset") String selectedDay, Model model) {
		
		itemForm.setCityChoices(getCityChoices());
		System.out.println(selectedDay);
		System.out.println(itemForm);
		
		if(result.hasErrors()) {
			model.addAttribute("itemForm", itemForm);
			return "hotel-list.html";
		}
		
		String dateStr = itemForm.getSaleDate();
		Date date = Date.valueOf(dateStr);
		LocalDate localDate = date.toLocalDate();
		String city = itemForm.getCity();
		ArrayList<Item> itemList = new ArrayList<>();
		selectedDay = selectedDay.replace(",", "");
		
		localDate = localDate.minusDays(Integer.parseInt(selectedDay));
		date = Date.valueOf(localDate);
		
		itemList = itemService.getItems(date, city);
		itemForm.setSaleDate(date.toString());
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemForm", itemForm);
		System.out.println(itemForm.getSaleDate());
		
		return "hotel-list.html";
	}
}

