package edu.miu.tvseries.eventlistener;

import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Slf4j
public class TVSeriesRatingEventListener {
    private  final RatingService ratingService;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "rating-movie-queue", durable = "true"),
            exchange = @Exchange(name = "rating-exchange", type = "fanout")
    ), containerFactory = "listenerContainerFactory")
    public void onRatingMovie(RatingDTO dto) {

        ratingService.addRating(dto);
        log.info("Received data: {}", dto);
    }
}
