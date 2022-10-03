package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.MrnDetail;
import com.ats.webapi.repository.MrnDetailRepository;

@Service
public class MrnService {

	@Autowired
	private MrnDetailRepository mrnDetailRepository;

	public MrnDetail findByIdMrnDetail(int id) {
		MrnDetail mrnDetail = mrnDetailRepository.findByIdMrnDetail(id); 
		System.out.println(mrnDetail.getMrn().getId());  
		return mrnDetail;
	}

}
