package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.ItemIssueDetail;

public interface ItemIssueDetailRepository extends JpaRepository<ItemIssueDetail, Integer>, 
JpaSpecificationExecutor<ItemIssueDetail> {

	@Transactional
	@Modifying
	int deleteIssueDetailById(int id);

}
