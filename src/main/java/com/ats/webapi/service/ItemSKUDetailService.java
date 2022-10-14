package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ItemSKUDetail;
import com.ats.webapi.repository.ItemSKUDetailRepository;

@Service
public class ItemSKUDetailService {

	@Autowired
	private ItemSKUDetailRepository itemSKUDetailRepository;

	public ItemSKUDetail saveItemSKUDetail(ItemSKUDetail itemSKUDetail) {

		return itemSKUDetailRepository.save(itemSKUDetail);
	}

	public ItemSKUDetail getById(int id) {
		Optional<ItemSKUDetail> projectionItem = itemSKUDetailRepository.findById(id);

		if (Objects.isNull(projectionItem.get())) {

			throw new ResourceNotFoundException("Item Not found with Id " + id);
		}

		return projectionItem.get();
	}

	public List<ItemSKUDetail> findAll() {

		return itemSKUDetailRepository.findAll();
	}

	public int deleteById(int id) {

		return itemSKUDetailRepository.deleteItemSKUDetailById(id);
	}

	public List<ItemSKUDetail> findByProjectionItemId(int id) {
		return itemSKUDetailRepository.findByProjectionItemId(id);
	}

}
