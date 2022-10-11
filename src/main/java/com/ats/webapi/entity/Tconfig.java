package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "t_config")
public class Tconfig {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name="key")
	private String key;

	@Column(name = "value")
	private String value;

}
