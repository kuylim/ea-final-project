package edu.miu.movie.service;

import edu.miu.movie.dto.CommentMovieDTO;
import edu.miu.movie.entity.Comment;

public interface CommentService {
    public Comment addComment(CommentMovieDTO dto);
}
