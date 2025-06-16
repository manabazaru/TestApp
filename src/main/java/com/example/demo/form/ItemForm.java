package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
	
	@NotNull
	private String saleDate;
	
	@NotNull
	private int quantity;
	
	@NotBlank
	private String city;
	
	private String[] cityChoices;
}
