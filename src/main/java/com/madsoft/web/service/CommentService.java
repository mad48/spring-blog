package com.madsoft.web.service;


import com.madsoft.web.form.CommentForm;
import com.madsoft.web.model.Comment;
import com.madsoft.web.model.Post;
import com.madsoft.web.utils.HibernateSessionFactory;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CommentService implements ICommentService {

/*
    // list comments
    @Override
    public List findAllComments() {
        System.out.println("findAllComments()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List comments = null;
        try {
            tx = session.beginTransaction();
            comments = session.createQuery("FROM Comment").list();
            for (Iterator iterator = comments.iterator(); iterator.hasNext(); ) {
                Comment comment = (Comment) iterator.next();
                */
/*System.out.print("id: " + comment.getId());
                System.out.print(" Title: " + comment.getTitle());
                System.out.print(" Text: " + comment.getText());
                System.out.println(" Tags: " + comment.getTags());*//*

            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return comments;
    }
*/

    // get getCommentsByPostId
    @Override
    public List getCommentsByPostId(Integer postId) {
        System.out.println("getCommentsByPostId(" + postId + ")");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List comments = null;

        try {
            tx = session.beginTransaction();
            comments = session.createQuery("FROM Comment WHERE postid=:postId").setParameter("postId", postId).list();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return comments;
    }

    // get comment
    @Override
    public Comment getComment(Integer commentId) {
        System.out.println("getText()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Comment comment = null;
        try {
            comment = session.get(Comment.class, commentId);
            Hibernate.initialize(comment);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return comment;
    }


    // add comment
    public Integer addComment(CommentForm commentForm) {
        System.out.println("addComment()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer commentID = null;
        try {
            tx = session.beginTransaction();
            Comment comment = new Comment();
            comment.setPostid(commentForm.getPostid());
            comment.setName(commentForm.getName());
            comment.setEmail(commentForm.getEmail());
            comment.setText(commentForm.getText());


            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            comment.setOwner(auth.getName());


            commentID = (Integer) session.save(comment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return commentID;
    }


    // update comment
    public void updateComment(Comment comment, CommentForm commentForm) {
        System.out.println("updateComment()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Comment comment = (Comment) session.get(Comment.class, commentId);
            comment.setName(commentForm.getName());
            comment.setEmail(commentForm.getEmail());
            comment.setText(commentForm.getText());
            session.update(comment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    // delete comment
    @Override
    public void deleteComment(Comment comment, Post post) {
        System.out.println("deleteComment(" + comment.getId() + ")");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            tx = session.beginTransaction();
            //Comment comment = (Comment) session.get(Comment.class, CommentID);
            // if owner
/*            if (post.getOwner().equalsIgnoreCase(auth.getName()) && comment.getPostid() == post.getId()) {
                session.delete(comment);
            }*/
            session.delete(comment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
