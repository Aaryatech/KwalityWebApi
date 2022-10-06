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

import com.ats.webapi.entity.Tax;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.TaxService;

@RestController
@RequestMapping("/tax")
public class TaxController {
	
	@Autowired
	private TaxService taxService;

	@PostMapping
	public ServiceResponse saveTax(@RequestBody @Valid Tax tax)
			throws DataIntegrityViolationException {
		return ServiceResponse.asSuccess(taxService.saveTax(tax));

	}

	@GetMapping("/{id}")
	public ServiceResponse getTaxById(@PathVariable int id) {

		Tax tax = taxService.findTaxById(id);
		return ServiceResponse.asSuccess(tax);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(taxService.findAll());

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		taxService.deleteTaxById(id);

		return ServiceResponse.asSuccess("success");
	}

}
