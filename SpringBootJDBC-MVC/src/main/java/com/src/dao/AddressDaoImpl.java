package com.src.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.src.entity.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void add(Address address) {
		jdbcTemplate.update("insert into Address values(?,?)", new Object[] { address.getA_id(), address.getA_area() });
	}

	@Override
	public void update(Address address) {
		jdbcTemplate.update("update  Address set a_area=? where a_id=?", new Object[] { address.getA_area(), address.getA_id() });

	}

	@Override
	public void deletebyid(String a_area) {
		jdbcTemplate.update("delete from Address where a_area=?", new Object[] { a_area });

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Address> findall() {
		return jdbcTemplate.query("select *from Address", new BeanPropertyRowMapper(Address.class));
	}

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public Address findbyid(String a_area) {
		return (Address) jdbcTemplate.queryForObject("select *from Address where a_area=?", new Object[] { a_area },
				new BeanPropertyRowMapper(Address.class));
	}

}
