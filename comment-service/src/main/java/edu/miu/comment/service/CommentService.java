package edu.miu.comment.service;

import edu.miu.comment.dto.CommentDTO;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
public interface CommentService {

    CommentDTO createNewComment(CommentDTO dto);
}
