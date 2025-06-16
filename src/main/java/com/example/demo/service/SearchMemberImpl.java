package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.mapper.MemberMapper;

@Service
public class SearchMemberImpl implements SearchMember{

	private MemberMapper memMapper;
	
	public SearchMemberImpl(MemberMapper memMapper) {
		this.memMapper = memMapper;
	}
	
	public Member searchMember(String memberCode) {
		Member member = memMapper.selectMemberByMemberCode(memberCode);
		
		return member;
		
	}
}
