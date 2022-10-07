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

import com.ats.webapi.entity.UnitofMeasure;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.UnitofMeasureService;

@RestController
@RequestMapping("/unit-of-measure")
public class UnitofMeasureController {

	@Autowired
	private UnitofMeasureService unitofMeasureService;

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
	
	@GetMapping("get-all")
	public List<UnitofMeasure> getAll() throws Exception {

		return unitofMeasureService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		unitofMeasureService.deleteUnitofMeasureById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	@GetMapping("/{id}/delete-by-uom-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = unitofMeasureService.deleteUnitofMeasureById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("UOM Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete UOM");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete UOM");
			e.printStackTrace();
		}

		return info;

	}

}
