/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.registration;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.SessionManager;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.util.HibernateUtil;
import com.segvek.taskmanager.service.util.RandomHexCode;
import com.segvek.taskmanager.service.util.Sender;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Query;
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
        
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        user.setDateRegistration(format1.format(d));
        
        org.hibernate.Session hses = HibernateUtil.getSessionFactory().openSession();
        hses.beginTransaction();
        hses.save(user);
        hses.getTransaction().commit();
        hses.close();
        
        SessionManager sessionManager = SessionManagerImpl.getInstance();
//        Object tempObj = SpringUtil.getInstance().getBean("sessionManager");
//        if (tempObj instanceof SessionManager) {
//            sessionManager = (SessionManager) tempObj;
//        } else {
//            throw new ExceptionInInitializerError("Не соответствие типов при инициализации");
//        }

        Session session = sessionManager.createSession();
        session.setAttribute("user", user.getId());
        return    "<registration><sessionId>" + session.getIdSession() + "</sessionId></registration>";
    }
    
    /**
     * Функция подсчитівает колличество зарегстированых пользователей с указаной почтой
     * @param mail
     * @return 
     */
    private int getCountUserWithThisMail(String mail){
        org.hibernate.Session sesHib = HibernateUtil.getSessionFactory().openSession();
        Query queru =  sesHib.createQuery("FROM User Where mail like :mail");
        queru.setParameter("mail",mail);
        int countUser = queru.list().size();
        sesHib.close();
        return countUser;
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
