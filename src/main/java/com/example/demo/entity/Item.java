package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable{
	
	private String itemCode;
	
	private String itemName;
	
	private int price;
	
	private int stock;
	
	private Date saleDate;
	
	private String city;
}
