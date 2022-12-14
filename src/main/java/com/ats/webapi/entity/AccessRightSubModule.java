package com.ats.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_module_sub")
public class AccessRightSubModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_module_id")
	private int subModuleId;

	@Column(name = "module_id")
	private int moduleId;

	@Column(name = "sub_module_name")
	String subModulName;

	@Column(name = "sub_module_mapping")
	String subModuleMapping;

	@Column(name = "sub_module_desc")
	String subModuleDesc;

	@Column(name = "type")
	private int type;

	@Column(name = "view")
	private int view;

	@Column(name = "add_approve_config")
	private int addApproveConfig;

	@Column(name = "edit_reject")
	private int editReject;

	@Column(name = "delete_reject_approve")
	private int deleteRejectApprove;

	@Column(name = "is_delete")
	private int isDelete;

	@Column(name = "order_by")
	private int orderBy;

	public int getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(int subModuleId) {
		this.subModuleId = subModuleId;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getSubModulName() {
		return subModulName;
	}

	public void setSubModulName(String subModulName) {
		this.subModulName = subModulName;
	}

	public String getSubModuleMapping() {
		return subModuleMapping;
	}

	public void setSubModuleMapping(String subModuleMapping) {
		this.subModuleMapping = subModuleMapping;
	}

	public String getSubModuleDesc() {
		return subModuleDesc;
	}

	public void setSubModuleDesc(String subModuleDesc) {
		this.subModuleDesc = subModuleDesc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getAddApproveConfig() {
		return addApproveConfig;
	}

	public void setAddApproveConfig(int addApproveConfig) {
		this.addApproveConfig = addApproveConfig;
	}

	public int getEditReject() {
		return editReject;
	}

	public void setEditReject(int editReject) {
		this.editReject = editReject;
	}

	public int getDeleteRejectApprove() {
		return deleteRejectApprove;
	}

	public void setDeleteRejectApprove(int deleteRejectApprove) {
		this.deleteRejectApprove = deleteRejectApprove;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "AccessRightSubModule [subModuleId=" + subModuleId + ", moduleId=" + moduleId + ", subModulName="
				+ subModulName + ", subModuleMapping=" + subModuleMapping + ", subModuleDesc=" + subModuleDesc
				+ ", type=" + type + ", view=" + view + ", addApproveConfig=" + addApproveConfig + ", editReject="
				+ editReject + ", deleteRejectApprove=" + deleteRejectApprove + ", isDelete=" + isDelete + ", orderBy="
				+ orderBy + "]";
	}

}
