package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.UnitofMeasure;

public interface UnitofMeasureRepository extends JpaRepository<UnitofMeasure, Integer>,JpaSpecificationExecutor<UnitofMeasure> {

	UnitofMeasure findById(int id);

	@Transactional
	@Modifying
	int deleteUnitofMeasureById(int id);

}
