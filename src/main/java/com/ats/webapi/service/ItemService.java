package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Item;
import com.ats.webapi.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item saveItem(Item item) throws DataIntegrityViolationException {

		Item itemSaveResponse = itemRepository.save(item);

		if (Objects.isNull(itemSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a item " + item.getItemName());
		}

		return itemSaveResponse;

	}
	public List<Item> findAll()
	{
        return itemRepository.findAll();
    }

	public Item findItemById(int id) throws ResourceNotFoundException {

		Item itemOpt = itemRepository.findById(id);
		
		if (Objects.isNull(itemOpt)) {
			
			throw new ResourceNotFoundException("Item Not Found With Id " +id);
		}

		return itemOpt;

	}
	
	public int deleteItemById(int id) throws ResourceNotFoundException {


		return itemRepository.deleteItemById(id);

	}
	public List<Item> findItemByCategoryId(int id) {
		// TODO Auto-generated method stub
		return itemRepository.findItemByCategoryId(id);
	}

}
