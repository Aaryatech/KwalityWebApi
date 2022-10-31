package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.ItemSKUDetail;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ItemSKUDetailService;

@RestController
@RequestMapping("/itemSKUDetail")
public class ItemSKUDetailController {

	@Autowired
	private ItemSKUDetailService itemSKUDetailService;

	@PostMapping
	public ServiceResponse saveItemSKUDetail(@RequestBody List<ItemSKUDetail> itemSKUDetail) {

		return ServiceResponse.asSuccess(itemSKUDetailService.saveItemSKUDetail(itemSKUDetail));

	}

	@GetMapping("/{id}")
	public ServiceResponse getById(@PathVariable int id) {

		ItemSKUDetail itemSKUDetail = itemSKUDetailService.getById(id);
		return ServiceResponse.asSuccess(itemSKUDetail);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(itemSKUDetailService.findAll());

	}

	@GetMapping("/delete/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		itemSKUDetailService.deleteById(id);
		return ServiceResponse.asSuccess("success");
	}

}
