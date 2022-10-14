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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "opening_stock_header")
@Data
public class OpeningStockHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="from_date")
	private Date fromDate;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="month")
	private String month;
	
	@Column(name="year")
	private String year;
	
	@Column(name="status")
	private int status;
	
	@OneToMany(targetEntity = OpeningStockDetail.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "opening_stock_header_id", referencedColumnName = "id",nullable=false)
	private List<OpeningStockDetail>  openingStockDetail;

}
