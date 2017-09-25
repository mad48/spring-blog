package com.madsoft.web.service;

import com.madsoft.web.utils.HibernateSessionFactory;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginService {

/*    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }*/

    public boolean checkLogin(String login, String password) {
        System.out.println("In Check login");

        boolean userFound = false;

        // Session session = sessionFactory.openSession();

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        //Query using Hibernate Query Language
        String SQL_QUERY = " from User as o where o.login=? and o.password=?";
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter(0, login);
        query.setParameter(1, password);
        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound = true;
        }

        session.close();

        return userFound;
    }
}