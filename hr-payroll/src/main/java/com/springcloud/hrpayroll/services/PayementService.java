package com.springcloud.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.hrpayroll.entities.Payement;
import com.springcloud.hrpayroll.entities.Worker;
import com.springcloud.hrpayroll.feignClients.WorkerFeignClient;

@Service
public class PayementService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient; 
	
	public Payement getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payement(worker.getName(), worker.getDailyIncome(), days);
	}
}
