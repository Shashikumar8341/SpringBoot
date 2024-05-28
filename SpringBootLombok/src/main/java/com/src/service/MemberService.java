package com.src.service;

import java.util.List;

import com.src.entity.Member;

public interface MemberService {

	public Member add(Member member);

	public Member update(Member member);

	public Member deletebyid(Integer id);

	public Member findbyid(Integer id);

	public List<Member> findall();
}
