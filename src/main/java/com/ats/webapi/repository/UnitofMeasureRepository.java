package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.entity.UnitofMeasure;

public interface UnitofMeasureRepository extends JpaRepository<UnitofMeasure, Integer>,JpaSpecificationExecutor<UnitofMeasure> {

	@Query("select c from UnitofMeasure c where c.id=:id")
	UnitofMeasure findByUomId(int id);

	@Transactional
	@Modifying
	int deleteUnitofMeasureById(int id);

	@Query("select c from UnitofMeasure c ")
	List<UnitofMeasure> findAllUom();

}
