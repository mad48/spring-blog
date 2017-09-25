package com.madsoft.web.model;

import javax.persistence.*;

//import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "posts", catalog = "springtest")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "owner", nullable = false, length = 255)
    private String owner;

    @Column(name = "title", nullable = false, length = 65535) // unique = true,
    private String title;

    @Column(name = "text", nullable = false, length = 65535)
    private String text;

    @Column(name = "tags", nullable = false, length = 255)
    private String tags;

    public Post() {
    }

    public Post(String title, String text, String tags) {
        this.title = title;
        this.text = text;
        this.tags = tags;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    //Check if this is for New of Update
    public boolean isNew() {
        return (this.id == null);
    }
}