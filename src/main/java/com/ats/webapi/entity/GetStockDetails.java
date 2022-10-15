package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GetStockDetails {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="rol")
	private double rol;
	
	@Column(name="opening_quantity")
	private int openingQuantity;
	
	@Column(name="approved_quantity")
	private int approvedQuantity;
	
	@Column(name="issue_quantity")
	private int issueQuantity;
	
	@Column(name="closing_quantity")
	private int closingQuantity;

}
