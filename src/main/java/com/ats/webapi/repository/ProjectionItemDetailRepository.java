package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.ProjectionItemDetail;

@Repository
public interface ProjectionItemDetailRepository
		extends JpaRepository<ProjectionItemDetail, Integer>, JpaSpecificationExecutor<ProjectionItemDetail> {
	@Transactional
	@Modifying 
	int deleteProjectionItemDetailById(int id);

	@Query("select c from ProjectionItemDetail c where c.projectionItemId=:id")
	List<ProjectionItemDetail> findByItemId(int id);

	@Transactional
	@Modifying
	int deleteProjectionItemDetailByProjectionItemId(int id);

}
