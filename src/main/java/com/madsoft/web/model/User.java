package com.madsoft.web.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;


    @Column(name = "username", unique = true, length = 255) // unique = true,nullable = false,
    @Size(min = 3, max = 30)
    private String username;

    @Column(name = "password", length = 255)//nullable = false,
    @NotEmpty
    private String password;

    @Column(name = "email", length = 255)// nullable = false,
    @Email
    @NotEmpty
    private String email;

    @Column(name = "enabled")
    private String enabled;

/*  @DateTimeFormat(pattern="yyyy/MM/dd")
    @Past @NotNull
    private Date created_at;*/

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    //Check if this is for New of Update
    public boolean isNew() {
        return (this.id == null);
    }

/*
    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName
                + ", sex=" + sex + ", dob=" + dob + ", email=" + email
                + ", section=" + section + ", country=" + country
                + ", firstAttempt=" + firstAttempt + ", subjects=" + subjects
                + "]";
    }
*/

}



/*
    Для этого сначала нужно получить имя юзера из spring-security

public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
        }

        и передать его в hibernate

public User getUserByUsername(String username) {
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> userRequest = criteriaQuery.from(User.class);

        Expression<String> exp = userRequest.get("username");
        Predicate predicate = exp.in(username);

        criteriaQuery.where(predicate);
        try {
        return em.createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException e) {
        return new User();
        }
        }
*/

