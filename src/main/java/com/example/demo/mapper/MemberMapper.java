package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Member;

@Mapper
public interface MemberMapper {
	
	public Member selectMemberByMemberCode(String memberCode);
}
