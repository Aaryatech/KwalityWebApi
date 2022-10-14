package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item_sku_detail")
@Data
public class ItemSKUDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "item_sku_id")
	private int itemSkuId;

	@Column(name = "rm_id")
	private int rmId;
 
	@Column(name = "rm_qty")
	private float rmQty;
	
	@Column(name = "no_of_piece")
	private int noOfPiece;

}
