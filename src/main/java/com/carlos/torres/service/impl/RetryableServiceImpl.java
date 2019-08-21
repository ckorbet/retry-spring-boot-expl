package com.carlos.torres.service.impl;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.carlos.torres.service.RetryableService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RetryableServiceImpl implements RetryableService {

	@Override
	@Retryable(value = { UnsupportedOperationException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public void falingMethod() {
		log.info("Invocation to 'failingMethod'");
		throw new UnsupportedOperationException("Throwing exception to force retry");
	}

	@Override
	public Boolean successMethod() {
		log.info("Invocation to 'successMethod'");
		return true;
	}

	@Override
	@Recover
	public void recoveryMethod(final UnsupportedOperationException uoExcp) {
		log.info("Invocation to 'recoveryMethod'");
		log.error(uoExcp.getMessage());		
	}
}