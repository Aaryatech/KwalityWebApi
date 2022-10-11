package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Item;
import com.ats.webapi.entity.Mrn;
import com.ats.webapi.entity.MrnDetail;
import com.ats.webapi.entity.Tconfig;
import com.ats.webapi.repository.MrnDetailRepository;
import com.ats.webapi.repository.MrnRepository;
import com.ats.webapi.repository.TconfigRepository;

@Service
public class MrnService {

	@Autowired
	private MrnRepository mrnRepository;
	
	@Autowired
	private MrnDetailRepository mrnDetailRepository;
	
	@Autowired
	private TconfigRepository tConfigRepository;
	
	@Autowired
	ItemService itemService;

	public Mrn saveMrn(Mrn mrn) {
		
		String key="MRN";
		Tconfig tconfig=tConfigRepository.findTconfigByKey(key);
		String value=tconfig.getValue();
		
		mrn.setMrnNo("MRN"+value);
		String number = value;
		int numberLength = number.length();
		int temp = Integer.parseInt(number);

		temp = temp + 1;

		int digit = Integer.toString(Math.abs(temp)).trim().length();

		for (int j = 1; j <= numberLength; j++) {

			if (digit == j) {

				int n = numberLength - j;
				String appendZero = IntStream.range(0, n).mapToObj(k -> "0").collect(Collectors.joining(""));
				number = appendZero + temp;

			}
		}
		
		List<MrnDetail> mrnDetailList=new ArrayList<MrnDetail>();
		mrnDetailList=mrn.getMrnDetail();
		double totTax=0;
		double total=0;
		double totTaxable=0;
		for(int i=0;i<mrnDetailList.size();i++)
		{		
			totTax=totTax+mrnDetailList.get(i).getTaxAmount();
			totTaxable=totTaxable+mrnDetailList.get(i).getTaxableAmount();
			total=total+mrnDetailList.get(i).getTotalAmount();		
		}
		mrn.setTaxAmount(totTax);
		mrn.setTaxableAmount(totTaxable);
		mrn.setTotalAmount(total);
		 
		Mrn mrnSaveResponse = mrnRepository.save(mrn);
		
		int result=tConfigRepository.updateTconfig(number,key);

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

	public int deleteMrnDetailById(int id) {
	
		return mrnDetailRepository.deleteMrnDetailById(id);
	}

}
