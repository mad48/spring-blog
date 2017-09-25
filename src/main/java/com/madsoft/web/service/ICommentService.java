package com.madsoft.web.service;

import com.madsoft.web.form.CommentForm;
import com.madsoft.web.model.Comment;
import com.madsoft.web.model.Post;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


public interface ICommentService {
    @PreAuthorize("hasRole('ROLE_USER')")
    public Integer addComment(CommentForm commentForm);

    //@CommentAuthorize("returnObject.owner == authentication.name")
    public Comment getComment(Integer CommentId);

    @PreAuthorize("#post.owner == authentication.name && #comment.postid == #post.id")
    public void deleteComment(Comment comment, Post post);

    @PreAuthorize("#comment.owner == authentication.name")
    public void updateComment(Comment comment, CommentForm commentForm);//public void updateComment(Integer commentId, CommentForm commentForm);


    List getCommentsByPostId(Integer postId);
}