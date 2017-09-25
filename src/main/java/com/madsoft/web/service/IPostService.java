package com.madsoft.web.service;


import com.madsoft.web.form.PostForm;
import com.madsoft.web.model.Post;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


public interface IPostService {
    //@PreAuthorize("hasRole('ROLE_WRITE')")
    public Integer addPost(PostForm postForm);

    //@PostAuthorize("returnObject.owner == authentication.name")
    public Post getPost(Integer PostId);

    @PreAuthorize("#post.owner == authentication.name")
    public void deletePost(Post post);

    @PreAuthorize("#post.owner == authentication.name")
    public void updatePost(Post post, PostForm postForm);//public void updatePost(Integer postId, PostForm postForm);


    List findAllPosts();//<Post>

    public Long getPostsCountByUser(String username);

}