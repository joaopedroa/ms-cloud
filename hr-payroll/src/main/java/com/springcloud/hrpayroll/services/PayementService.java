package com.springcloud.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springcloud.hrpayroll.entities.Payement;
import com.springcloud.hrpayroll.entities.Worker;

@Service
public class PayementService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	public Payement getPayment(long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", String.valueOf(workerId));
		
		String uri = workerHost + "/workers/{id}";
		
		Worker worker = restTemplate.getForObject(uri, Worker.class, uriVariables);
		
		return new Payement(worker.getName(), worker.getDailyIncome(), days);
	}
}
