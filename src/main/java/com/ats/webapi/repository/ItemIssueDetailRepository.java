package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ats.webapi.entity.ItemIssueDetail;

public interface ItemIssueDetailRepository extends JpaRepository<ItemIssueDetail, Integer>, 
JpaSpecificationExecutor<ItemIssueDetail> {

}
