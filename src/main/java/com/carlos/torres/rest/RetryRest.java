package com.carlos.torres.rest;

import org.springframework.http.ResponseEntity;

public interface RetryRest {
	
	ResponseEntity<String> retry(Boolean retry);
}