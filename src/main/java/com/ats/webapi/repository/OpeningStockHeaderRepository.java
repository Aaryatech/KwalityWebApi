package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.OpeningStockHeader;

public interface OpeningStockHeaderRepository extends JpaRepository<OpeningStockHeader, Integer>, 
JpaSpecificationExecutor<OpeningStockHeader> {
	
	OpeningStockHeader findById(int id);

	@Transactional
	@Modifying
	int deleteOpeningStockHeaderById(int id);
	

}
