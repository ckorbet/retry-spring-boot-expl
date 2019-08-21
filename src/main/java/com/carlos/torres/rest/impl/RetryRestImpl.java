package com.carlos.torres.rest.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.torres.rest.RetryRest;
import com.carlos.torres.service.RetryableService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/retry", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class RetryRestImpl implements RetryRest {
	
	@Autowired
	private RetryableService retSer;
	
	@GetMapping
	@Override
	public final ResponseEntity<String> retry(@Valid @RequestParam(value = "retry", required = true) Boolean retry) {
		log.info("Received REST request to 'retry'...");
		String res;
		if(retry) {			
			try {
				res = "failingMethod";
				this.retSer.falingMethod();				
			} catch (UnsupportedOperationException uoExcp) {
				res = uoExcp.getMessage();
			}
		} else {
			this.retSer.successMethod();
			res = "successMethod";
		}
		log.info("Serving response");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}