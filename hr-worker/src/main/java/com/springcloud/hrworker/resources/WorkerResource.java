package com.springcloud.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.hrworker.entities.Worker;
import com.springcloud.hrworker.reposiotries.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private WorkerRepository repository;
	
	@Autowired
	private Environment env;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> findConfigs(){
		String testConfig = env.getProperty("test.config");
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return new ResponseEntity<List<Worker>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker = repository.findById(id).get();
		return new ResponseEntity<Worker>(worker, HttpStatus.OK);
	}
}
