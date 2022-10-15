package com.ats.webapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.GetStockDetails;
import com.ats.webapi.entity.OpeningStockHeader;
import com.ats.webapi.repository.GetStockDetailRepository;
import com.ats.webapi.repository.OpeningStockHeaderRepository;

@Service
public class OpeningStockHeaderService {
	
	@Autowired
	private OpeningStockHeaderRepository openingStockHeaderRepository;
	
	@Autowired
	private GetStockDetailRepository getStockDetailRepository;

	public OpeningStockHeader saveOpeningStockHeader(OpeningStockHeader openingStockHeader) throws DataIntegrityViolationException {

		OpeningStockHeader openingStockHeaderSaveResponse = openingStockHeaderRepository.save(openingStockHeader);

		if (Objects.isNull(openingStockHeaderSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a openingStockHeader ");
		}

		return openingStockHeaderSaveResponse;

	}
	public List<OpeningStockHeader> findAll()
	{
        return openingStockHeaderRepository.findAll();
    }

	public OpeningStockHeader findOpeningStockHeaderById(int id) throws ResourceNotFoundException {

		OpeningStockHeader openingStockHeaderOpt = openingStockHeaderRepository.findById(id);
		
		if (Objects.isNull(openingStockHeaderOpt)) {
			
			throw new ResourceNotFoundException("Opening Stock Header Not Found With Id " +id);
		}

		return openingStockHeaderOpt;

	}
	
	public int deleteOpeningStockHeaderById(int id) throws ResourceNotFoundException {


		return openingStockHeaderRepository.deleteOpeningStockHeaderById(id);

	}
	public List<GetStockDetails> getStockDetails() {
		
		Date date=new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = formatter.format(date);  
	
		return getStockDetailRepository.getStockDetails(strDate);
	}
	public List<GetStockDetails> getStockDetailsWithRol() {
		
		Date date=new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = formatter.format(date);  
	
		return getStockDetailRepository.getStockDetailsWithRol(strDate);
	}

}
