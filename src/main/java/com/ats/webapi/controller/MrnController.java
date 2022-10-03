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

import com.ats.webapi.entity.Mrn;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.repository.MrnRepository;
import com.ats.webapi.service.MrnService;

@RestController
@RequestMapping("mrn")
public class MrnController {

	@Autowired
	private MrnRepository mrnRepository;

	@Autowired
	MrnService mrnService;

	@PostMapping
	public ServiceResponse saveSubject(@RequestBody @Valid Mrn subject) throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(mrnRepository.save(subject));

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		mrnRepository.deleteById(id);

		return ServiceResponse.asSuccess("success");
	}

	@GetMapping("/{id}")
	public ServiceResponse getSubject(@PathVariable int id) {

		Mrn list = mrnRepository.findById(id).get();
		list.getMrnList();
		return ServiceResponse.asSuccess(list);

	}

	@GetMapping
	public ServiceResponse getList() throws Exception {

		return ServiceResponse.asSuccess(mrnRepository.findAll());

	}

	@GetMapping("/{id}/mrndetail")
	public ServiceResponse getmrndetail(@PathVariable int id) {

		return ServiceResponse.asSuccess(mrnService.findByIdMrnDetail(id));

	}
}
