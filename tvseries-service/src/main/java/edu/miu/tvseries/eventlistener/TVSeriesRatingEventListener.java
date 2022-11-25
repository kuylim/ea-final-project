package edu.miu.tvseries.eventlistener;

import edu.miu.tvseries.controller.dto.CommentTVSeriesDTO;
import edu.miu.tvseries.controller.dto.RatingDTO;
import edu.miu.tvseries.entity.Rating;
import edu.miu.tvseries.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class TVSeriesRatingEventListener {
    private  final RatingService ratingService;


//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "rating-tvseries-queue", durable = "true"),
//            exchange = @Exchange(name = "rating-exchange", type = "fanout")
//    ), containerFactory = "listenerContainerFactory")
//    public void onRatingMovie(RatingDTO dto) {
//        log.info("Received data before : {}", dto);
//        ratingService.addRating(dto);
//        log.info("Received data after: {}", dto);
//    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "rating-tvseries-queue", durable = "true"),
            exchange = @Exchange(name = "rating-exchange", type = "fanout")
    ), containerFactory = "listenerContainerFactory")
    public void onRatingMovie(Rating dto) {
        ratingService.addRating(dto);
        log.info("Received data: {}", dto);
    }
}
