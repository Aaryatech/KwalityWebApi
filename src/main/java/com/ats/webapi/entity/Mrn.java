package com.ats.webapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "mrn_header")
@Data
public class Mrn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "mrn_no")
	private String mrnNo;
	
	@Column(name="mrn_type")
	private int mrnType;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="mrn_date")
	private Date mrnDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="vendor_id",referencedColumnName="id")
	private Vendor vendor;
	
	@Column(name="gate_entry_no")
	private String gateEntryNo;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="gate_entry_date")
	private Date gateEntryDate;
	
	@Column(name="doc_no")
	private String docNo;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="doc_date")
	private Date docDate;
	
	@Column(name="bill_no")
	private String billNo;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="bill_date")
	private Date billDate;
	
	@Column(name="transport")
	private String transport;
	
	@Column(name="lr_no")
	private String lrNo;
	
	@Column(name="taxable_amount")
	private double taxableAmount;
	
	@Column(name="tax_amount")
	private double taxAmount;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="lr_date")
	private Date lrDate;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="mrn_status")
	private int mrnStatus;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="insert_date_time")
	private Date insertDateTime;
		
	@OneToMany(targetEntity = MrnDetail.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mrn_id", referencedColumnName = "id")
	private List<MrnDetail>  mrnDetail;

//	@OneToMany(mappedBy = "mrn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonManagedReference
//	private List<MrnDetail> mrnList;


}
