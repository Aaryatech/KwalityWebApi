package com.ats.webapi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mrn_header")
public class Mrn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotNull(message = "code can't be null.")
	@Column(name = "mrn_no")
	private String mrnNo;

//	@OneToMany(targetEntity = MrnDetail.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "mrn_id", referencedColumnName = "id", nullable = false)

	@OneToMany(mappedBy = "mrn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<MrnDetail> mrnList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public List<MrnDetail> getMrnList() {
		return mrnList;
	}

	public void setMrnList(List<MrnDetail> mrnList) {
		this.mrnList = mrnList;
	}

	@Override
	public String toString() {
		return "Mrn [id=" + id + ", mrnNo=" + mrnNo + ", mrnList=" + mrnList + "]";
	}

}
