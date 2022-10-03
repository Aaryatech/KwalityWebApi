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

@Entity
@Table(name = "mrn_detail")
public class MrnDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mrn_Id")
	@JsonBackReference
	private Mrn mrn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mrn getMrn() {
		return mrn;
	}

	public void setMrn(Mrn mrn) {
		this.mrn = mrn;
	}

	@Override
	public String toString() {
		return "MrnDetail [id=" + id + ", mrn=" + mrn + "]";
	}

}
