package edu.miu.rating.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Configuration
public class RabbitConfiguration {

    @Bean("rabbitMessageConverter")
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter(createObjectMapper());
    }

    private ObjectMapper createObjectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Bean("customRabbitTemplate")
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue commentMovieQueue() {
        return new Queue("rating-movie-queue", true);
    }

    @Bean
    public Queue commentTVSeriesQueue() {
        return new Queue("rating-tvseries-queue", true);
    }

    @Bean
    public FanoutExchange commentExchange() {
        return new FanoutExchange("rating-exchange");
    }

    @Bean
    public Binding commentExchangeMovieQueueBinding(Queue commentMovieQueue, FanoutExchange commentExchange) {
        return BindingBuilder.bind(commentMovieQueue).to(commentExchange);
    }

    @Bean
    public Binding commentExchangeTVSeriesQueueBinding(Queue commentTVSeriesQueue, FanoutExchange commentExchange) {
        return BindingBuilder.bind(commentTVSeriesQueue).to(commentExchange);
    }

    @Bean
    ApplicationRunner runner(ConnectionFactory cf) {
        return args -> {
            boolean open = false;
            while (!open) {
                try {
                    cf.createConnection().close();
                    open = true;
                } catch (Exception e) {
                    Thread.sleep(5000);
                }
            }
        };
    }
}
