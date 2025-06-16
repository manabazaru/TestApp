package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService{

	private ItemMapper itemMapper;
	
	public ItemServiceImpl(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}
	
	@Override
	public String[] getCities() {
		return this.itemMapper.selectCities();
	}
	
	@Override
	public ArrayList<Item> getItems(Date date, String city){
		return this.itemMapper.selectItems(date, city);
	}
}
