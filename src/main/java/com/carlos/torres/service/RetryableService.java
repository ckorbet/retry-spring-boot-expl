package com.carlos.torres.service;

public interface RetryableService {
	
	void falingMethod();
	
	Boolean successMethod();
	
	void recoveryMethod(UnsupportedOperationException uoExcp);
}
