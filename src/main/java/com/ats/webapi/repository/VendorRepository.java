package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.UnitofMeasure;
import com.ats.webapi.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Integer>, JpaSpecificationExecutor<Vendor> {
	
	Vendor findById(int id);

	@Transactional
	@Modifying
	int deleteVendorById(int id);

}
