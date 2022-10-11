package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.Tax;
import com.ats.webapi.entity.Tconfig;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.TconfigService;

@RestController
@RequestMapping("/t-config")
public class TconfigController {
	
	@Autowired
	TconfigService tconfigService;
	
	@GetMapping("/{key}/get-by-key")
	public Tconfig findTconfigByKey(@PathVariable String key) {

		return tconfigService.findTconfigByKey(key);

	}

}
