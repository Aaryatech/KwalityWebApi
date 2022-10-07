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
import com.ats.webapi.entity.Vendor;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;

	@PostMapping
	public ServiceResponse saveVendor(@RequestBody @Valid Vendor vendor)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(vendorService.saveVendor(vendor));

	}

	@GetMapping("/{id}")
	public ServiceResponse getVendorById(@PathVariable int id) {

		Vendor vendor = vendorService.findVendorById(id);
		return ServiceResponse.asSuccess(vendor);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(vendorService.findAll());

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		vendorService.deleteVendorById(id);

		return ServiceResponse.asSuccess("success");
	}

	
	
	
	@GetMapping("get-all")
	public List<Vendor> getAll() throws Exception {

		return vendorService.findAll();

	}
	
	
	@GetMapping("/{id}/delete-by-vendor-id")
	public  Info deleteVendor(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = vendorService.deleteVendorById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Vendor Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Vendor");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Vendor");
			e.printStackTrace();
		}

		return info;

	}
	
	
	

}
