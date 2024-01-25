package com.analytics.data.message;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.analytics.data.dto.CarPostDTO;
import com.analytics.data.service.PostAnalyticsService;

@Component
public class KafkaConsumetMessage {

	private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumetMessage.class);
	
	@Autowired
	private PostAnalyticsService postAnalyticsService;
	
	@KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
	public void listening(@Payload CarPostDTO carPost) {
		LOG.info("Analytics data recived Car Post Information : {}", carPost);
		postAnalyticsService.saveAnalytics(carPost);
	}
}
