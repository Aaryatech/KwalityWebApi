package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

	@Query("select c from Category c where c.id=:id")
	Category findByCategoryId(int id);

	@Transactional
	@Modifying
	int deleteCategoryById(int id);

	@Query("select c from Category c")
	List<Category> findAllRecord();

}
