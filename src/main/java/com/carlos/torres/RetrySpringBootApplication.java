package com.carlos.torres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * <p>
 * Main class for retry application
 * </p>
 */
@SpringBootApplication
@EnableRetry
public class RetrySpringBootApplication {
	
	public static final void main(final String[] args) {
        SpringApplication.run(RetrySpringBootApplication.class, args);
    }
}