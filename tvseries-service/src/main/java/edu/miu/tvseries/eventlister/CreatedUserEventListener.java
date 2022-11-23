package edu.miu.tvseries.eventlister;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.tvseries.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CreatedUserEventListener {

    private final ObjectMapper mapper;

    @KafkaListener(topics = "movie-create-user", containerFactory = "kafkaListenerStringContainerFactory",
            groupId = "movie-create-user")
    public void onCreatedUser(ConsumerRecord<String, String> cr, @Payload String message) {
        log.info("========> raw message: {}", message);
        try {
            UserDTO dto = mapper.readValue(message, UserDTO.class);
            log.info("=========> User Object: {}", dto);
            // todo save to database here
        } catch (Exception ex) {
            log.info("=========> convert JSON string to object error: ", ex);
        }
    }
}
