package com.ats.webapi.controller;

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

import com.ats.webapi.entity.UnitofMeasure;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.UnitofMeasureService;

@RestController
@RequestMapping("/unit-of-measure")
public class UnitofMeasureController {

	@Autowired
	UnitofMeasureService unitofMeasureService;

	@PostMapping
	public ServiceResponse saveUnitofMeasure(@RequestBody @Valid UnitofMeasure unitofMeasure)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(unitofMeasureService.saveUnitofMeasure(unitofMeasure));

	}

	@GetMapping("/{id}")
	public ServiceResponse getUnitofMeasureById(@PathVariable int id) {

		UnitofMeasure unitofMeasure = unitofMeasureService.findUnitofMeasureById(id);
		return ServiceResponse.asSuccess(unitofMeasure);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(unitofMeasureService.findAll());

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		unitofMeasureService.deleteUnitofMeasureById(id);

		return ServiceResponse.asSuccess("success");
	}

}
