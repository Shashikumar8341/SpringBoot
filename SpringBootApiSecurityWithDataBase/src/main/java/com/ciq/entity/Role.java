
package com.ciq.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLE_TAB")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	
	@Column(nullable = false, unique = true)
	private String rname;

}
