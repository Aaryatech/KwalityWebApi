package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ats.webapi.entity.OpeningStockDetail;

public interface OpeningStockDetailRepository extends JpaRepository<OpeningStockDetail, Integer>,
JpaSpecificationExecutor<OpeningStockDetail> {

}
