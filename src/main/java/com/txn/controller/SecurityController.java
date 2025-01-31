package com.txn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.txn.dto.Response;
import com.txn.dto.Transaction;
import com.txn.service.FraudMgntService;

@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired FraudMgntService fraudMgntService;
	
	
	
	@PostMapping("/validate")
	public ResponseEntity<Response> validateTxn(@RequestBody Transaction txn) {
		
		return ResponseEntity.ok(fraudMgntService.validateTxn(txn));
	}
	
	
}