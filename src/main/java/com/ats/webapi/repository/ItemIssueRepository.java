package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.ItemIssue;

public interface ItemIssueRepository extends JpaRepository<ItemIssue, Integer>, 
JpaSpecificationExecutor<ItemIssue> {
	
	ItemIssue findById(int id);

	@Transactional
	@Modifying
	int deleteItemIssueById(int id);

}
