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

import com.ats.webapi.entity.GetStockDetails;
import com.ats.webapi.entity.OpeningStockHeader;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.OpeningStockHeaderService;

@RestController
@RequestMapping("/opening-stock-heaader")
public class OpeningStockHeaderController {
	
	@Autowired
	private OpeningStockHeaderService openingStockHeaderService;

	@PostMapping
	public ServiceResponse saveOpeningStockHeader(@RequestBody @Valid OpeningStockHeader openingStockHeader)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(openingStockHeaderService.saveOpeningStockHeader(openingStockHeader));

	}

	@GetMapping("/{id}")
	public ServiceResponse getOpeningStockHeaderById(@PathVariable int id) {

		OpeningStockHeader openingStockHeader = openingStockHeaderService.findOpeningStockHeaderById(id);
		return ServiceResponse.asSuccess(openingStockHeader);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(openingStockHeaderService.findAll());

	}
	
	@GetMapping("get-all")
	public List<OpeningStockHeader> getAll() throws Exception {

		return openingStockHeaderService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		openingStockHeaderService.deleteOpeningStockHeaderById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	@GetMapping("/{id}/delete-by-uom-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = openingStockHeaderService.deleteOpeningStockHeaderById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("UOM Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Opening Stock");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Opening stock");
			e.printStackTrace();
		}

		return info;

	}
	
	@GetMapping("/get-stock-details")
	public List<GetStockDetails> getStockDetails() throws Exception {

		return openingStockHeaderService.getStockDetails();

	}
	

}
