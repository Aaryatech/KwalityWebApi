package com.ats.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Tconfig;
import com.ats.webapi.repository.TconfigRepository;

@Service
public class TconfigService {
	
	@Autowired
	TconfigRepository tconfigRepository;
	
	public Tconfig findTconfigByKey(String key)
	{
        return tconfigRepository.findTconfigByKey(key);
    }

}
