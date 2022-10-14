package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.ItemSKU;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ItemSKUService;

@RestController
@RequestMapping("/itemSKU")
public class ItemSKUController {

	@Autowired
	private ItemSKUService itemSKUService;

	@PostMapping
	public ServiceResponse saveItemSKU(@RequestBody ItemSKU itemSKU) {

		return ServiceResponse.asSuccess(itemSKUService.saveItemSKU(itemSKU));

	}

	@GetMapping("/{id}")
	public ServiceResponse getItemById(@PathVariable int id) {

		ItemSKU itemSKU = itemSKUService.getItemById(id);
		return ServiceResponse.asSuccess(itemSKU);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(itemSKUService.findAll());

	}

	@GetMapping("/delete/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		itemSKUService.deleteById(id);
		return ServiceResponse.asSuccess("success");
	}

}
