package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Vendor;
import com.ats.webapi.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor saveVendor(Vendor vendor) throws DataIntegrityViolationException {

		Vendor vendorSaveResponse = vendorRepository.save(vendor);

		if (Objects.isNull(vendorSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a vendor " + vendor.getName());
		}

		return vendorSaveResponse;

	}
	public List<Vendor> findAll()
	{
        return vendorRepository.findVendorAll();
    }

	public Vendor findVendorById(int id) throws ResourceNotFoundException {

		Vendor vendorOpt = vendorRepository.findByVendorId(id);
		
		if (Objects.isNull(vendorOpt)) {
			
			throw new ResourceNotFoundException("Unit of Measure Not Found With Id " +id);
		}

		return vendorOpt;

	}
	
	public int deleteVendorById(int id) throws ResourceNotFoundException {


		return vendorRepository.deleteVendorById(id);

	}

}
