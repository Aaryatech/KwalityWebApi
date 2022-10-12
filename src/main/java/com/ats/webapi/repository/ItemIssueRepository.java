package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.ItemIssue;
import com.ats.webapi.entity.Mrn;

public interface ItemIssueRepository extends JpaRepository<ItemIssue, Integer>, 
JpaSpecificationExecutor<ItemIssue> {
	
	ItemIssue findById(int id);

	@Transactional
	@Modifying
	int deleteItemIssueById(int id);
	
	@Query(value="select i.* from item_issue i WHERE i.issue_date BETWEEN :fromDate AND :toDate ",nativeQuery=true)
	List<ItemIssue> getIssueByDate(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
