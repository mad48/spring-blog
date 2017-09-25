package com.madsoft.web.service;

import com.madsoft.web.model.Role;
import com.madsoft.web.utils.HibernateSessionFactory;
import com.madsoft.web.model.User;
import org.hibernate.*;

import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;


//@Service("userService")
@Service
public class UserService {// implements IUserService


    public UserService() {

    }

    public User getUser(String username) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        User user = null;
        List users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User WHERE username=:username").setParameter("username", username).list();
            tx.commit();
/*
            user = session.get(User.class, username);
            user = session.createQuery("FROM User");*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        Iterator iterator = users.iterator();
        user = (User) iterator.next();

        return user;

    }

    public User getUser2(String username) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        User user = null;
        try {
            user = session.get(User.class, username);
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    /* Method to CREATE an user in the database */
    public Integer addUser(String username, String password, String email) {
        System.out.println("addUser()" + username);
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;
        try {
            tx = session.beginTransaction();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setEnabled("1");
            userID = (Integer) session.save(user);

            Role role = new Role();
            role.setUsername(username);
            role.setRole("ROLE_USER");
            session.save(role);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }


    /* Method to SAVE salary for an user */
    public Integer save(User user) {
        System.out.println(" save user ()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;
        try {
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }


    public User getUserById(Integer UserId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        User user = null;
        try {
            user = session.get(User.class, UserId);
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    /* Method to  READ all the users */
    public List listUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        List users = null;
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
                User user = (User) iterator.next();
                System.out.print("id: " + user.getId());
                System.out.print(" Username: " + user.getUsername());
                System.out.print(" Password: " + user.getPassword());
                System.out.println(" Email: " + user.getEmail());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    // UPDATE
    public void update(User user) {
        System.out.println(" update user ()");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

/*    *//* Method to UPDATE salary for an user *//*
    public void updateUser(Integer UserID, String tags) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, UserID);
            user.setTags(tags);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }*/


    /* Method to DELETE an user from the records */
    public void deleteUser(Integer UserID) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = (User) session.get(User.class, UserID);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
