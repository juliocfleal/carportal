package com.store.carportal.message;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.store.carportal.dto.CarPostDTO;
import com.store.carportal.service.CarPostService;

@Component
public class KafkaConsumetMessage {

	private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumetMessage.class);
	
	@Autowired
	private CarPostService carPostService;
	
	@KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
	public void listening(CarPostDTO carPost) {
		LOG.info("Car store recived Car Post Information : {}", carPost);
		carPostService.newPostDetails(carPost);
	}
}
