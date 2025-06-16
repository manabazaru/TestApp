package com.example.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable{
	
	private String memberCode;
	
	private String memberName;
	
	private String mail;
	
	private String password;
}
