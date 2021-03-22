package com.springcloud.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.springcloud.hrpayroll.entities.Payement;

@Service
public class PayementService {
	
	public Payement getPayment(long workerId, int days) {
		return new Payement("Bob", 200.0, days);
	}
}
