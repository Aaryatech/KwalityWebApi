package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.ItemSKU;
import com.ats.webapi.entity.ItemSKUDetail;

@Repository
public interface ItemSKUDetailRepository
		extends JpaRepository<ItemSKUDetail, Integer>, JpaSpecificationExecutor<ItemSKUDetail> {
	@Transactional
	@Modifying
	int deleteItemSKUDetailById(int id);

//	@Query(value="select p from ItemSKUDetail p INNER JOIN ItemSKU s ON p.itemSkuId = s.id and s.projectionItemId=:id")
	@Query(value = "select p from ItemSKUDetail p,ItemSKU s where p.itemSkuId = s.id and s.projectionItemId=:id")
	List<ItemSKUDetail> findByProjectionItemId(int id);

	@Transactional
	@Modifying
	int deleteItemSKUDetailByItemSkuIdIn(List<Integer> id);

}
