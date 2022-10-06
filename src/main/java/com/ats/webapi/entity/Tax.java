package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tax")
@Data
public class Tax {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "cgst")
	private double cgst;

	@Column(name = "sgst")
	private double sgst;

	@Column(name = "igst")
	private double igst;
	
	@Column(name="cees")
	private double cees;

	@Column(name = "hsn_code")
	private String hsnCode;
}
