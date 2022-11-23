package edu.miu.userservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic movieCreateUser() {
        return new NewTopic("movie-create-user", 1, (short) 1);
    }

    @Bean
    public NewTopic tvSeriesCreateUser() {
        return new NewTopic("tv-series-create-user", 1, (short) 1);
    }
}
