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

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Data;

@Entity
@Table(name = "item")
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_code")
	private String itemCode;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	@Column(name = "rol")
	private double rol;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "uom_id", referencedColumnName = "id")
	private UnitofMeasure unitofMeasure;

	@Column(name = "rate")
	private double rate;

	@Column(name = "weight")
	private double weight;

	@Column(name = "length")
	private float length;

	@Column(name = "width")
	private float width;

	@Column(name = "height")
	private float height;

	@Column(name = "moisture_level")
	private float moistureLevel;

	@Column(name = "no_of_pieces")
	private int noOfPieces;

	@Column(name = "calculate_by_qty")
	private int calculateByQty;

	@Column(name = "calculate_yield")
	private int calulateYield;

	@Column(name = "inclusive_rate")
	private double inclusiveRate;

	@ManyToOne(fetch = FetchType.EAGER, optional = true) 
	@JoinColumn(name = "tax_id", referencedColumnName = "id")
	private Tax tax;

}
