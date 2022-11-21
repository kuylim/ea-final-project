package edu.miu.comment.service.impl;

import edu.miu.comment.dto.CommentDTO;
import edu.miu.comment.entity.Comment;
import edu.miu.comment.repository.CommentRepository;
import edu.miu.comment.service.CommentService;
import edu.miu.sharemodule.enumerate.VideoType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final AmqpTemplate amqpTemplate;

    public CommentServiceImpl(CommentRepository repository,
                             @Qualifier("customRabbitTemplate") AmqpTemplate amqpTemplate) {
        this.repository = repository;
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public CommentDTO createNewComment(CommentDTO dto) {
        Comment comment = new Comment();
        log.info("-===> dto: {}", dto);
        BeanUtils.copyProperties(dto, comment, "id");
        comment = repository.save(comment);
        log.info("===> entity: {}", comment);
        if(VideoType.MOVIE.equals(dto.getVideoType())) {
            amqpTemplate.convertAndSend("comment-exchange", "comment-movie-queue", comment);
        }
        amqpTemplate.convertAndSend("comment-exchange", "comment-tvseries-queue", comment);
        return dto;
    }
}
