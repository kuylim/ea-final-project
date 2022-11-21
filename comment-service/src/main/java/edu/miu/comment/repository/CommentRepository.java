package edu.miu.comment.repository;

import edu.miu.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/21/2022
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
