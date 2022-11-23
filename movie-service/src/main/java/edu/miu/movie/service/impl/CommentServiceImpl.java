package edu.miu.movie.service.impl;

import edu.miu.movie.dto.CommentMovieDTO;
import edu.miu.movie.dto.RatingDTO;
import edu.miu.movie.entity.Comment;
import edu.miu.movie.entity.Rating;
import edu.miu.movie.repository.CommentRepository;
import edu.miu.movie.repository.RatingRepository;
import edu.miu.movie.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment addComment(CommentMovieDTO dto) {
        Comment comment = new Comment();
        log.info("-===> dto: {}", dto);
        BeanUtils.copyProperties(dto, comment);
        comment = commentRepository.save(comment);
        return comment;
    }
}
