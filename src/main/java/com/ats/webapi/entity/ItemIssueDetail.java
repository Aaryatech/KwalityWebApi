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
@Table(name = "item_issue_detail")
@Data
public class ItemIssueDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="item_group_id")
	private int itemGroupId;
	
	@Column(name="item_category")
	private int itemCategory;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id",referencedColumnName="id")
	private Item item;
	
	@Column(name="item_issue_qty")
	private int itemIssueQty;
	
	@Column(name="mrn_detail_id")
	private int mrnDetailId;
	
	@Column(name="requisition_detail_id")
	private int requisitionDetailId;

}
