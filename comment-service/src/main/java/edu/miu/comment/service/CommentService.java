package edu.miu.comment.service;

import edu.miu.comment.dto.CommentDTO;
import edu.miu.comment.entity.Comment;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface CommentService {

    CommentDTO createNewComment(CommentDTO dto);

    List<Comment> getAllComment();

    Comment getOneComment(Long id);

    void deleteOne(Long id);
}
