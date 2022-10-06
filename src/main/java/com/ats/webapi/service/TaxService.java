package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Tax;
import com.ats.webapi.repository.TaxRepository;

@Service
public class TaxService {
	
	@Autowired
	private TaxRepository taxRepository;
	
	public Tax saveTax(Tax tax) throws DataIntegrityViolationException {

		Tax taxSaveResponse = taxRepository.save(tax);

		if (Objects.isNull(taxSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a tax " + tax.getName());
		}

		return taxSaveResponse;

	}
	public List<Tax> findAll()
	{
        return taxRepository.findAll();
    }

	public Tax findTaxById(int id) throws ResourceNotFoundException {

		Tax taxOpt = taxRepository.findById(id);
		
		if (Objects.isNull(taxOpt)) {

			throw new ResourceNotFoundException("Tax Not Found With Id " +id);
			}

		return taxOpt;

	}
	
	public int deleteTaxById(int id) throws ResourceNotFoundException {


		return taxRepository.deleteTaxById(id);

	}
	

}
