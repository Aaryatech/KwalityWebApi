package com.ats.webapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.Item;
import com.ats.webapi.entity.Vendor;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@PostMapping
	public ServiceResponse saveItem(@RequestBody @Valid Item item)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(itemService.saveItem(item));

	}

	@GetMapping("/{id}")
	public ServiceResponse getItemById(@PathVariable int id) {

		Item item = itemService.findItemById(id);
		return ServiceResponse.asSuccess(item);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(itemService.findAll());

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		itemService.deleteItemById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	

	@GetMapping("get-all")
	public List<Item> getAll() throws Exception {

		return itemService.findAll();

	}
	
	
	@GetMapping("/{id}/delete-by-item-id")
	public  Info deleteItem(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = itemService.deleteItemById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Item Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Item");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Item");
			e.printStackTrace();
		}

		return info;

	}
	

}
