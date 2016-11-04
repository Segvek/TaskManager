/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.authorization;

import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.SessionManager;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.HibernateUtil;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import java.io.StringReader;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.Expression;
import org.hibernate.criterion.Example;
import org.xml.sax.InputSource;

/**
 * При авторизации проходит проверка прав пользователя и в слечае успешной
 * проверки создаеться новая сессия в которой обозначен атрибут user
 *
 * @author Panas
 */
public class AuthorizationFunction implements Function {

    @Override
    public String processes(String xml) throws Exception {
        ParserAuthorization handler = new ParserAuthorization();
        try {
            InputSource source = new InputSource(new StringReader(xml));
            SAXParserUtil.getParser().parse(source, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = handler.getUser();

        SessionManager sessionManager = SessionManagerImpl.getInstance();
//        Object tempObj = SpringUtil.getInstance().getBean("sessionManager");
//        if (tempObj instanceof SessionManager) {
//            sessionManager = (SessionManager) tempObj;
//        } else {
//            throw new ExceptionInInitializerError("Не соответствие типов при инициализации");
//        }

        //проверка пользователя должна быть здесь
        System.out.println(user);
        org.hibernate.Session sessiondao = HibernateUtil.getSessionFactory().openSession();
        List<User> users =sessiondao.createCriteria(User.class).add(Example.create(user)).list();
        sessiondao.close();
        if (users.size()>0) {
            user = users.get(0);
            Session session = sessionManager.createSession();
            session.setAttribute("user", user);
            return "<authorization><sessionId>" + session.getIdSession() + "</sessionId></authorization>";
        } else {
            return "<error>User not found</error>";
        }
    }

}
