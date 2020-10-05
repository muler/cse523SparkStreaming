package com.miu.KafkaProject.sendReceiveMessage;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;


import com.miu.KafkaProject.Employee;

@Service
public class MessageConsumer {

	@KafkaListener(topics = "myTopic", 
			groupId = "group-id", 
			containerFactory = "userKafkaListenerContainerFactory")
	public void consumeUserDetials(Employee employeDetails) {
		if(employeDetails != null) {
			String EmplD = "id:"+employeDetails.getId() +
					" name:"+employeDetails.getName() +
					" titile:"+employeDetails.getTitle() +
					" salary:"+employeDetails.getTitle();
			System.out.println("Details of Employee");
			System.out.println(EmplD);
		}
	}
}
