package edu.miu.comment.controller;

import edu.miu.comment.dto.CommentDTO;
import edu.miu.comment.entity.Comment;
import edu.miu.comment.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public List<Comment> getAllComments(){

      return  commentService.getAllComment();
    }

    @GetMapping("/{id}")
    public Comment getOneComment(@PathVariable Long id){

        return  commentService.getOneComment(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){

        commentService.deleteOne(id);
    }
}
