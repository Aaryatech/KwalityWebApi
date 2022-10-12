package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Mrn;
import com.ats.webapi.entity.MrnDetail;

@Repository
public interface MrnRepository extends JpaRepository<Mrn, Integer>, JpaSpecificationExecutor<Mrn> {

	Mrn findById(int id);

	@Transactional
	@Modifying
	int deleteMrnById(int id);
	
	@Query(value="select m.* from mrn_header m WHERE m.mrn_date BETWEEN :fromDate AND :toDate ",nativeQuery=true)
	List<Mrn> getMrnByDate(@Param("fromDate")String fromDate,@Param("toDate")String toDate);


	
}
