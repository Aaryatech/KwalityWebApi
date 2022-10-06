package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Tax;
@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer>,JpaSpecificationExecutor<Tax>{
	
	Tax findById(int id);

	@Transactional
	@Modifying
	int deleteTaxById(int id);


}
