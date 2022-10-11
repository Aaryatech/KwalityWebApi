package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.MrnDetail;
@Repository
public interface MrnDetailRepository extends JpaRepository<MrnDetail, Integer>, JpaSpecificationExecutor<MrnDetail> {

	@Query(value = "select u from MrnDetail u where u.id=:id")
	MrnDetail findByIdMrnDetail(@Param("id") int id);

	@Transactional
	@Modifying
	int deleteMrnDetailById(int id);

}
