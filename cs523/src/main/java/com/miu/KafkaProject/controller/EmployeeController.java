package com.miu.KafkaProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.miu.KafkaProject.Employee;
import com.miu.KafkaProject.sendReceiveMessage.MessageProducer;

@RestController
public class EmployeeController {

	@Autowired
	private MessageProducer messageProducer;
	@PostMapping("/employee")
	public ResponseEntity<Object> saveUserDetails(@RequestBody Employee employeeDetails){
		messageProducer.sendMessageToKafka(employeeDetails);
		return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
	}
}
