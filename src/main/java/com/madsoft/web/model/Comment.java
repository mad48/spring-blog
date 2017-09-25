package com.madsoft.web.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "comments")

public class Comment {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "owner", nullable = false, length = 255)
    private String owner;

    @Column(name = "post_id", nullable = false)
    private Integer postid;

    @Column(name = "name", nullable = false, length = 65535)
    private String name;

    @Column(name = "email", nullable = false, length = 65535)
    private String email;

    @Column(name = "text", nullable = false, length = 65535)
    private String text;

    public Comment() {
    }


    public Comment(Integer postid, String name, String email, String text) {
        this.postid = postid;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}