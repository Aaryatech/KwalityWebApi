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
public interface MrnDetailRepository extends JpaRepository<MrnDetail, Integer>, JpaSpecificationExecutor<MrnDetail> {

	@Query(value = "select u from MrnDetail u where u.id=:id")
	MrnDetail findByIdMrnDetail(@Param("id") int id);

	@Transactional
	@Modifying
	int deleteMrnDetailById(int id);

	@Query(value="    SELECT\n" + 
			"        sum(mrd.remaining_qty) as batch_no,\n" + 
			"        mrd.* \n" + 
			"    FROM\n" + 
			"        mrn_detail mrd ,mrn_header mrh\n" + 
			"    WHERE\n" + 
			"    mrh.id=mrd.mrn_id  AND\n" + 
			"        mrd.item_id=:id AND mrd.remaining_qty>0 AND mrh.mrn_date<=:date\n" + 
			"    GROUP BY\n" + 
			"        mrd.item_id",nativeQuery=true)
	MrnDetail findRemainingQuantityByItemId(int id,@Param("date")String date);

	@Query(value="Select m from MrnDetail m where m.item.id=:itemId ")
	List<MrnDetail> getMrnDetailByItemId(@Param("itemId")int itemId);

}
