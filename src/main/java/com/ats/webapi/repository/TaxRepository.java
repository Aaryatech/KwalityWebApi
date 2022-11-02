package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Tax;
@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer>,JpaSpecificationExecutor<Tax>{
	
	@Query("select c from Tax c where c.id=:id")
	Tax findByTaxId(int id);

	@Transactional
	@Modifying
	int deleteTaxById(int id);

	@Query("select c from Tax c ")
	List<Tax> findAllTax();


}
