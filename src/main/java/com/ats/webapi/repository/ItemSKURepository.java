package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.entity.ItemSKU;

@Repository
public interface ItemSKURepository extends JpaRepository<ItemSKU, Integer>, JpaSpecificationExecutor<ItemSKU> {
	@Transactional
	@Modifying
	int deleteItemSKUById(int id);

	List<ItemSKU> findByProjectionItemId(int id);

	@Transactional
	@Modifying
	int deleteItemSKUByprojectionItemId(int id);

	@Query(value=" select s.id from ItemSKU s where s.projectionItemId=:id")
	List<Integer> getIdByProjectionId(@Param("id") int id);

}
