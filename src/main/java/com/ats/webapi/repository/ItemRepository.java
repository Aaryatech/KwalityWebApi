package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.entity.Item;
import com.ats.webapi.entity.Vendor;

public interface ItemRepository extends JpaRepository<Item,Integer>, JpaSpecificationExecutor<Item> {
	
	@Query("select c from Item c where c.id=:id")
	Item findItemDetailById(int id);

	@Transactional
	@Modifying
	int deleteItemById(int id);

	@Query("select c from Item c where c.category.id=:id")
	List<Item> findItemByCategoryId(int id);

	@Query("select c from Item c ")
	List<Item> findAllItemDetail();

}
