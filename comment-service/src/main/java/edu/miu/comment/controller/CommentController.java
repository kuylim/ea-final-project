package edu.miu.comment.controller;

import edu.miu.comment.dto.CommentDTO;
import edu.miu.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentDTO createNewComment(@RequestBody CommentDTO dto) {
        return commentService.createNewComment(dto);
    }
}
