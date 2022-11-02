package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.ProjectionItem;

@Repository
public interface ProjectionItemRepository
		extends JpaRepository<ProjectionItem, Integer>, JpaSpecificationExecutor<ProjectionItem> {
	@Transactional
	@Modifying
	int deleteProjectionItemById(int id);

	@Query("select c from ProjectionItem c ")
	List<ProjectionItem> findProjectionItemAll();

	@Query("select c from ProjectionItem c where c.id=:id")
	ProjectionItem getItemById(int id);

}
