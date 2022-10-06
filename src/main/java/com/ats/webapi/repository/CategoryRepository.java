package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category>{

	Category findById(int id);

	@Transactional
	@Modifying
	int deleteCategoryById(int id);
	
}
