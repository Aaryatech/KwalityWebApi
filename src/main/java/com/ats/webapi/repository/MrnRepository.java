package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.Mrn;

@Repository
public interface MrnRepository extends JpaRepository<Mrn, Integer>, JpaSpecificationExecutor<Mrn> {

}
