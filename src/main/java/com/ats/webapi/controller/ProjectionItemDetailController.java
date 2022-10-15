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

import com.ats.webapi.entity.ProjectionItemDetail;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ProjectionItemDetailService;

@RestController
@RequestMapping("/projectionItemDetail")
public class ProjectionItemDetailController {

	@Autowired
	private ProjectionItemDetailService projectionItemDetailService;

	@PostMapping
	public ServiceResponse saveCategory(@RequestBody List<ProjectionItemDetail> projectionItemDetail) {

		return ServiceResponse.asSuccess(projectionItemDetailService.saveProjectionItemDetail(projectionItemDetail));

	}

	@GetMapping("/{id}")
	public ServiceResponse getItemById(@PathVariable int id) {

		ProjectionItemDetail projectionItemDetail = projectionItemDetailService.getDetailById(id);
		return ServiceResponse.asSuccess(projectionItemDetail);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(projectionItemDetailService.findAll());

	}

	@GetMapping("/delete/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		projectionItemDetailService.deleteById(id);
		return ServiceResponse.asSuccess("success");
	}

}
