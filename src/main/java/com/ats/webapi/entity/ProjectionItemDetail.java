package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "projection_item_detail")
@Data
public class ProjectionItemDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "projection_item_id")
	private int projectionItemId;

	@Column(name = "rm_id")
	private int rmId;

	@Column(name = "type")
	private int type;

	@Column(name = "qty")
	private float qty;

	@Column(name = "wastage")
	private float wastage;

}
