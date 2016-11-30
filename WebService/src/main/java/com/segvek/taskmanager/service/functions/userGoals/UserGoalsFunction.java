/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.userGoals;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.functions.FunctionHandler;
import com.segvek.taskmanager.service.model.Goal;
import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.HibernateUtil;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import java.io.StringReader;
import org.xml.sax.InputSource;

/**
 *
 * @author Panas
 */
public class UserGoalsFunction implements Function{

    @Override
    public String processes(String xml) throws Exception {
        FunctionHandler handler = new FunctionHandler();
        try {
            InputSource source = new InputSource(new StringReader(xml));
            SAXParserUtil.getParser().parse(source, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sessionid = handler.getSessionID();
        Session session = SessionManagerImpl.getInstance().getSession(sessionid);
        
        StringBuilder responce = new StringBuilder();
        if (session != null) {
            org.hibernate.Session hses = HibernateUtil.getSessionFactory().openSession();
            User user = (User) hses.get(User.class, (Long)session.getAttribute("user"));
            responce.append("<userGoals>");
            for(Goal goal:user.getGoals()){
                responce.append("<goal>");
                responce.append("<id>"+goal.getId()+"</id>");
                responce.append("<name>"+goal.getName()+"</name>");
                responce.append("<annotation>"+goal.getAnnotation()+"</annotation>");
                responce.append("<beginDate>"+goal.getStartDate()+"</beginDate>");
                responce.append("<endDate>"+goal.getEndDate()+"</endDate>");
                responce.append("<state>"+goal.getState()+"</state>");       
                responce.append("</goal>");
            }
            responce.append("</userGoals>");    
            
            hses.close();
        }else{
            responce.append("<error>Session not found</error>");
        }
        return responce.toString();
    }
}
