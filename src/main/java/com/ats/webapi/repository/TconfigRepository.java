package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.Tconfig;

public interface TconfigRepository extends JpaRepository<Tconfig, Integer>, 
JpaSpecificationExecutor<Tconfig> {

	Tconfig findTconfigByKey(String key);

	@Transactional
	@Modifying
	@Query(value="update t_config t SET t.value=:number WHERE t.key=:key ",nativeQuery=true)
	int updateTconfig(@Param("number")String number,@Param("key")String key);

}
