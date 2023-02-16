package edu.miu.tvseries.eventlistener;


import edu.miu.tvseries.controller.dto.CommentTVSeriesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Slf4j
@Component
public class TVSeriesCommentEventListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "tvseries-movie-queue", durable = "true"),
            exchange = @Exchange(name = "comment-exchange", type = "fanout")
    ), containerFactory = "listenerContainerFactory")
    public void onCommentMovie(CommentTVSeriesDTO dto) {

        log.info("Received data: {}", dto);
    }
}
