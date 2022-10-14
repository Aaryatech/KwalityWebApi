package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "opening_stock_detail")
@Data
public class OpeningStockDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id",referencedColumnName="id")
	private Item item;
	
	@Column(name="opening_quantity")
	private int openingQuantity;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private String year;

}
