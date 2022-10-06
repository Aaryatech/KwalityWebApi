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
@Table(name = "item")
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_cost")
	private double itemCost;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id",referencedColumnName="id")
	private Category category;

	@Column(name = "rol")
	private double rol;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="uom_id",referencedColumnName="id")
	private UnitofMeasure unitofMeasure;

	@Column(name = "rate")
	private double rate;

	@Column(name = "weight")
	private double weight;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tax_id",referencedColumnName="id")
	private Tax tax;

}
