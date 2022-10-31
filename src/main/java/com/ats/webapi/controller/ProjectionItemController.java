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

import com.ats.webapi.entity.ItemSKU;
import com.ats.webapi.entity.ItemSKUDetail;
import com.ats.webapi.entity.ProjectionItem;
import com.ats.webapi.entity.ProjectionItemDetail;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ItemSKUDetailService;
import com.ats.webapi.service.ItemSKUService;
import com.ats.webapi.service.ProjectionItemDetailService;
import com.ats.webapi.service.ProjectionItemService;

@RestController
@RequestMapping("/projectionItem")
public class ProjectionItemController {

	@Autowired
	private ProjectionItemService projectionItemService;

	@Autowired
	private ProjectionItemDetailService projectionItemDetailService;

	@Autowired
	private ItemSKUService itemSKUService;

	@Autowired
	private ItemSKUDetailService itemSKUDetailService;

	@PostMapping
	public ServiceResponse saveCategory(@RequestBody ProjectionItem projectionItem) {

		return ServiceResponse.asSuccess(projectionItemService.saveProjectionItem(projectionItem));

	}

	@GetMapping("/{id}")
	public ServiceResponse getItemById(@PathVariable int id) {

		ProjectionItem vendor = projectionItemService.getItemById(id);
		return ServiceResponse.asSuccess(vendor);

	}

	@GetMapping
	public List<ProjectionItem> findAll() throws Exception {

		return projectionItemService.findAll();

	}

	@GetMapping("/delete/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		projectionItemService.deleteById(id);
		return ServiceResponse.asSuccess("success");
	}

	@GetMapping("/{id}/projectionItemDetail")
	public List<ProjectionItemDetail> projectionItemDetail(@PathVariable int id) throws ResourceNotFoundException {

		return projectionItemDetailService.findByProjectionItemId(id);
	}

	@GetMapping("/{id}/itemSKUs")
	public List<ItemSKU> itemSKUs(@PathVariable int id) throws ResourceNotFoundException {

		return itemSKUService.findByProjectionItemId(id);
	}

	@GetMapping("/{id}/itemSKUsDetail")
	public List<ItemSKUDetail> itemSKUsDetail(@PathVariable int id) throws ResourceNotFoundException {

		return itemSKUDetailService.findByProjectionItemId(id);
	}

}
