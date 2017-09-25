package com.madsoft.web.service;


import com.madsoft.web.utils.HibernateSessionFactory;
import com.madsoft.web.form.PostForm;
import com.madsoft.web.model.Post;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

//@Service("postService")
@Component
public class PostService implements IPostService {

    // list posts
    @Override
    public List findAllPosts() {
        System.out.println("findAllPosts()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List posts = null;
        try {
            tx = session.beginTransaction();
            posts = session.createQuery("FROM Post").list();
            for (Iterator iterator = posts.iterator(); iterator.hasNext(); ) {
                Post post = (Post) iterator.next();
                /*System.out.print("id: " + post.getId());
                System.out.print(" Title: " + post.getTitle());
                System.out.print(" Text: " + post.getText());
                System.out.println(" Tags: " + post.getTags());*/
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return posts;
    }

    // get post
    @Override
    public Post getPost(Integer postId) {
        System.out.println("getPost()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Post post = null;
        try {
            post = session.get(Post.class, postId);
            Hibernate.initialize(post);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        //post.setText(post.getText().replace("/[\r\n]/", "<br />"));
        return post;
    }


    // add post
    public Integer addPost(PostForm postForm) {
        System.out.println("addPost()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer postID = null;
        try {
            tx = session.beginTransaction();
            Post post = new Post();
            post.setTitle(postForm.getTitle());
            post.setText(postForm.getText());
            post.setTags(postForm.getTags());


            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            post.setOwner(auth.getName());


            postID = (Integer) session.save(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return postID;
    }


    // update post
    public void updatePost(Post post, PostForm postForm) {
        System.out.println("updatePost()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Post post = (Post) session.get(Post.class, postId);
            post.setTitle(postForm.getTitle());
            post.setText(postForm.getText());
            post.setTags(postForm.getTags());
            session.update(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    // delete post
    @Override
    public void deletePost(Post post) {
        System.out.println("deletePost(" + post.getId() + ")");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            tx = session.beginTransaction();
/*            Post post = (Post) session.get(Post.class, PostID);
            // if owner
            if (post.getOwner().equalsIgnoreCase(auth.getName())) {
                session.delete(post);
            }*/
            session.delete(post);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // getPostsCountByUser
    @Override
    public Long getPostsCountByUser(String username) {

        System.out.println("getPostsCountByUser()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Long count = null;
        try {
            Query query = session.createQuery("SELECT count(*) FROM Post WHERE owner=:username");
            query.setParameter("username", username);
            count = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return count;
    }

}
