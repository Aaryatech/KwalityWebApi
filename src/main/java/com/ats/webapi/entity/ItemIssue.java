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
@Table(name = "item_issue")
@Data
public class ItemIssue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="issue_no")
	private String issueNo;
	
	@Column(name="type")
	private int type;
	
	@Column(name="item_category")
	private int itemCategory;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="issue_date")
	private Date issueDate;
	
	@Column(name="status")
	private int status;
	
	@Column(name="department_id")
	private String departmentId;
	
	@Column(name="sub_department_id")
	private int subDepartmentId;
	
	@OneToMany(targetEntity = ItemIssueDetail.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_issue_id", referencedColumnName = "id")
	private List<ItemIssueDetail>  itemIssueDetail;
	
	

}
