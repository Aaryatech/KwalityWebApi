package com.ats.webapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "m_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="emp_type_id")
	private int empTypeId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_pwd")
	private String userPassword;
	
	@Column(name="del_status")
	private short delStatus;
	
	@Column(name="is_active")
	private short isActive;
	
	@Column(name="maker_user_id")
	private int makerUserId;
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	@Column(name="maker_enter_datetime")
	private Date makerEnterDateTime;

}
