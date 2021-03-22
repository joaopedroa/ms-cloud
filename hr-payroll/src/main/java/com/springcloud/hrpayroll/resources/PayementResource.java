package com.springcloud.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.hrpayroll.entities.Payement;
import com.springcloud.hrpayroll.services.PayementService;

@RestController
@RequestMapping(value = "/payements")
public class PayementResource {
	
	@Autowired
	private PayementService service;
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payement> getPayement(@PathVariable Long workerId, @PathVariable Integer days){
		Payement payement = service.getPayment(workerId, days);
		return new ResponseEntity<Payement>(payement, HttpStatus.OK);
	}

}
