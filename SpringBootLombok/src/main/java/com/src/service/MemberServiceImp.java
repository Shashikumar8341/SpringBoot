package com.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.entity.Member;
import com.src.repositroy.EmployeRepositroy;


@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private EmployeRepositroy employeRepositroy;

	@Override
	public Member add(Member member) {
		return employeRepositroy.save(member);

	}

	@Override
	public Member update(Member member) {
		return employeRepositroy.save(member);

	}

	@Override
	public Member deletebyid(Integer id) {
		employeRepositroy.deleteById(id);
		;
		return deletebyid(id);
	}

	@Override
	public Member findbyid(Integer id) {
		employeRepositroy.findById(id);
		return findbyid(id);
	}

	@Override
	public List<Member> findall() {
		List<Member> member = employeRepositroy.findAll();
		return member;
	}

}
