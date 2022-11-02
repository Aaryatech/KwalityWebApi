package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.UnitofMeasure;
import com.ats.webapi.repository.UnitofMeasureRepository;

@Service
public class UnitofMeasureService {
	
	@Autowired
	private UnitofMeasureRepository unitofMeasureRepository;

	public UnitofMeasure saveUnitofMeasure(UnitofMeasure unitofMeasure) throws DataIntegrityViolationException {

		UnitofMeasure unitofMeasureSaveResponse = unitofMeasureRepository.save(unitofMeasure);

		if (Objects.isNull(unitofMeasureSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a unitofMeasure " + unitofMeasure.getName());
		}

		return unitofMeasureSaveResponse;

	}
	public List<UnitofMeasure> findAll()
	{
        return unitofMeasureRepository.findAllUom();
    }

	public UnitofMeasure findUnitofMeasureById(int id) throws ResourceNotFoundException {

		UnitofMeasure unitofMeasureOpt = unitofMeasureRepository.findByUomId(id);
		
		if (Objects.isNull(unitofMeasureOpt)) {
			
			throw new ResourceNotFoundException("Unit of Measure Not Found With Id " +id);
		}

		return unitofMeasureOpt;

	}
	
	public int deleteUnitofMeasureById(int id) throws ResourceNotFoundException {


		return unitofMeasureRepository.deleteUnitofMeasureById(id);

	}
	

}
