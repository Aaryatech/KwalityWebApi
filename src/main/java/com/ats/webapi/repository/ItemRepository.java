package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.Item;
import com.ats.webapi.entity.Vendor;

public interface ItemRepository extends JpaRepository<Item,Integer>, JpaSpecificationExecutor<Item> {
	
	Item findById(int id);

	@Transactional
	@Modifying
	int deleteItemById(int id);

	List<Item> findItemByCategoryId(int id);

}
