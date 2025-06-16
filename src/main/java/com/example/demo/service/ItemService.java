package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;

import com.example.demo.entity.Item;

public interface ItemService {
	public String[] getCities();
	
	public ArrayList<Item> getItems(Date date, String city);
}
