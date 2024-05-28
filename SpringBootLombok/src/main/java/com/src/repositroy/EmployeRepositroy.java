package com.src.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.src.entity.Member;

public interface EmployeRepositroy extends JpaRepository<Member, Integer> {

}
