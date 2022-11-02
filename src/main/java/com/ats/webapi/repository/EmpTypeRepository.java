package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.EmpType;
 
 

public interface EmpTypeRepository extends JpaRepository<EmpType, Integer>{

	
	List<EmpType> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("update EmpType set del_status=0  WHERE emp_type_id=:empTypeId")
	int deleteEmpType(@Param("empTypeId") int empTypeId);

	EmpType findByEmpTypeIdAndDelStatus(int empTypeId, int i);

	List<EmpType> findByDelStatusAndCompanyId(int i, int compId);

	List<EmpType> findByDelStatusAndCompanyIdOrderByEmpTypeIdDesc(int i, int compId);

	List<EmpType> findByDelStatusOrderByEmpTypeIdDesc(int i);

	@Transactional
	@Modifying
	@Query("update EmpType set del_status=0  WHERE emp_type_id=:accessRoleId")
	int deleteAceessRole(int accessRoleId);

}
