/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.registration;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.dao.DaoFactory;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.SessionManager;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.util.HibernateUtil;
import com.segvek.taskmanager.service.util.RandomHexCode;
import com.segvek.taskmanager.service.util.Sender;
import java.io.StringReader;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.xml.sax.InputSource;

/**
 *
 * @author Panas
 */
public class FunctionRegistration implements Function{

    @Override
    public String processes(String xml) throws Exception {
        User user = parseRequest(xml);
        /*TODO: возможен вариант изменить структуру БД а именно: сделать полу mail
             первичным ключем и при попытке добавить нового пользователя ловить исключение*/
        int countUser = getCountUserWithThisMail(user.getMail());        
        if(countUser>0)
            return    "<registration><error>A user with this email address already zaregistrirovan</error></registration>";
        
        user.setConfirmation(RandomHexCode.getHex());
        Sender.send("You`r key: "+user.getConfirmation(), user.getMail());
        DaoFactory.getFactory().getDaoUser().addEntity(user);
        
        SessionManager sessionManager = SessionManagerImpl.getInstance();
//        Object tempObj = SpringUtil.getInstance().getBean("sessionManager");
//        if (tempObj instanceof SessionManager) {
//            sessionManager = (SessionManager) tempObj;
//        } else {
//            throw new ExceptionInInitializerError("Не соответствие типов при инициализации");
//        }

        Session session = sessionManager.createSession();
        session.setAttribute("user", user);
        return    "<registration><sessionId>" + session.getIdSession() + "</sessionId></registration>";
    }
    
    /**
     * Функция подсчитівает колличество зарегстированых пользователей с указаной почтой
     * @param mail
     * @return 
     */
    private int getCountUserWithThisMail(String mail){
        User user = new User();
        user.setMail(mail);
        org.hibernate.Session sessiondao = HibernateUtil.getSessionFactory().openSession();
        List<User> users =sessiondao.createCriteria(User.class).add(Example.create(user)).list();
        sessiondao.close();
        return users.size();
    }
    
    /**
     * Функция предназначена для преобразования зпроса xml 
     * в сушбности данних
     * @param xml
     * @return 
     */
    private User parseRequest(String xml){
        ParserRegistration handler = new ParserRegistration();
        try {
            InputSource source = new InputSource(new StringReader(xml));
            SAXParserUtil.getParser().parse(source, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handler.getUser();
    }
}
