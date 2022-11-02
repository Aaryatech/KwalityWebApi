package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.entity.UnitofMeasure;
import com.ats.webapi.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Integer>, JpaSpecificationExecutor<Vendor> {
	
	@Query("select c from Vendor c where c.id=:id")
	Vendor findByVendorId(int id);

	@Transactional
	@Modifying
	int deleteVendorById(int id);

	@Query("select c from Vendor c ")
	List<Vendor> findVendorAll();

}
