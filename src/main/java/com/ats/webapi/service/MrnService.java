package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Mrn;
import com.ats.webapi.repository.MrnRepository;

@Service
public class MrnService {

	@Autowired
	private MrnRepository mrnRepository;

	public Mrn saveMrn(Mrn mrn) {

		Mrn mrnSaveResponse = mrnRepository.save(mrn);

		if (Objects.isNull(mrnSaveResponse)) {

			throw new DataIntegrityViolationException("Unable to save a mrn " );
		}

		return mrnSaveResponse;

	}

	public List<Mrn> findAll() {
		return mrnRepository.findAll();
	}

	public Mrn findMrnById(int id) throws ResourceNotFoundException {

		Mrn mrnOpt = mrnRepository.findById(id);

		if (Objects.isNull(mrnOpt)) {

			throw new ResourceNotFoundException("Mrn Not Found With Id " + id);
		}

		return mrnOpt;

	}

	public int deleteMrnById(int id) throws ResourceNotFoundException {

		return mrnRepository.deleteMrnById(id);

	}

}
