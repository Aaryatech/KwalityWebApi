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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "mrn_detail")
@Data
public class MrnDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id",referencedColumnName="id")
	private Item item;
	
	@Column(name="mrn_qty")
	private float mrnQty;
	
	@Column(name="rate")
	private double rate;
	
	@Column(name="taxable_amount")
	private double taxableAmount;
	
	@Column(name="tax_amount")
	private double taxAmount;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@Column(name="approved_qty")
	private float approvedQty;
	
	@Column(name="reject_qty")
	private float rejectQty;
	
	@Column(name="reject_remark")
	private String rejectRemark;
	
	@Column(name="mrn_detail_status")
	private int mrnDetailStatus;
	
	@Column(name="batch_no")
	private String batchNo;
	
	@Column(name="issue_qty")
	private float issueQty;
	
	@Column(name="remaining_qty")
	private float remainingQty;
	
	@Column(name="chalan_qty")
	private float chalanQty;
	
	
	

}
