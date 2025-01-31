package com.txn.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.txn.dto.Response;
import com.txn.dto.Transaction;
import com.txn.repo.BookRepo;

@Service
public class FraudMgntService {
	
	@Autowired BookRepo bookRepo;
	@Autowired KieContainer kieContainer;
	@Value("${kafka.topic.validate.res.name}") private String validationResTopicName;
	
	private KafkaTemplate<String, Transaction> kafkaTemplate = null;
	public FraudMgntService(KafkaTemplate<String, Transaction> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void listenValidateTxn(ConsumerRecord<String, Transaction> record) {
//		System.out.println("Receiver End: " + record.key() + ": "+  record.value().getAmount());
		Transaction txn = record.value();
		
		Response droolResponse = validateTxn(txn);
		String status = droolResponse.getStatus();
		if (status.equals("Valid")) {
			txn.setStatus("Completed");
		} else {
			txn.setStatus("Suspicious");
			txn.setMsg(droolResponse.getReason());
		}
		kafkaTemplate.send(validationResTopicName, txn);
	}
	
	public Response validateTxn(Transaction txnRequest) {
		
		Response response = new Response();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("response", response);
		kieSession.insert(txnRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return response;
	}
	
}