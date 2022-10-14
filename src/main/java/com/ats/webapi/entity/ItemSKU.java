package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item_sku")
@Data
public class ItemSKU {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "projection_item_id")
	private int projectionItemId;

	@Column(name = "sku_name")
	private String skuName;
 
	@Column(name = "item_qty")
	private float itemQty;
 

}
