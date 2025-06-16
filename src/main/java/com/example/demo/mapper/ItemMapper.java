package com.example.demo.mapper;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Item;

@Mapper
public interface ItemMapper {
	
	public ArrayList<Item> selectItems(Date date, String city);
	
	public String[] selectCities();
}
