package com.ats.webapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	@Column(name = "gst_per")
	private float gstPer;

	@Column(name = "selling_price_inclusive_gst")
	private float sellingPriceInclusiveGST;

	@Column(name = "scheme")
	private float scheme;

	@Column(name = "free_item")
	private float freeItem;

	@Column(name = "commision")
	private float commision;

}
