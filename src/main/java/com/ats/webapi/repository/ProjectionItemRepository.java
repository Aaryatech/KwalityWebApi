package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.ProjectionItem;

@Repository
public interface ProjectionItemRepository
		extends JpaRepository<ProjectionItem, Integer>, JpaSpecificationExecutor<ProjectionItem> {
	@Transactional
	@Modifying
	int deleteProjectionItemById(int id);

}
