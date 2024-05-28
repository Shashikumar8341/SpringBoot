package com.src.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class AddressDaoImpl extends AddressDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

}
