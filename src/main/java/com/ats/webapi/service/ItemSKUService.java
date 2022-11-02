package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ItemSKU;
import com.ats.webapi.repository.ItemSKURepository;

@Service
public class ItemSKUService {

	@Autowired
	private ItemSKURepository itemSKURepository;

	public ItemSKU saveItemSKU(ItemSKU itemSKU) {
		return itemSKURepository.save(itemSKU);
	}

	public ItemSKU getItemById(int id) {
		Optional<ItemSKU> itemSKU = itemSKURepository.findById(id);

		if (Objects.isNull(itemSKU.get())) {

			throw new ResourceNotFoundException("Item Not found with Id " + id);
		}

		return itemSKU.get();
	}

	public List<ItemSKU> findAll() {
		return itemSKURepository.findAll();
	}

	public int deleteById(int id) {
		return itemSKURepository.deleteItemSKUById(id); 
	}

	public List<ItemSKU> findByProjectionItemId(int id) {
		return itemSKURepository.getByProjectionItemId(id);
	}

	public int deleteByprojectionItemId(int id) {
		// TODO Auto-generated method stub
		return itemSKURepository.deleteItemSKUByprojectionItemId(id); 
	}
	
	public List<Integer> getIdByProjectionId(int id) {
		// TODO Auto-generated method stub
		return itemSKURepository.getIdByProjectionId(id); 
	}

}
