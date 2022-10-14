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
@Table(name = "projection_item")
@Data
public class ProjectionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "required_mosture_level")
	private float requiredMostureLevel;

	@Column(name = "item_gst")
	private float itemGst;

	@Column(name = "item_price_incl")
	private double itemPriceIncl;

	@Column(name = "commision")
	private float commision;

	@Column(name = "datetime")
	private String datetime;

}
