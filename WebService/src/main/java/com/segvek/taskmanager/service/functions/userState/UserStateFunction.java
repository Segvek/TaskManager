/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.userState;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.functions.FunctionHandler;
import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.SessionManager;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import java.io.StringReader;
import org.xml.sax.InputSource;

/**
 *
 * @author Panas
 */
public class UserStateFunction implements Function {

    @Override
    public String processes(String xml) throws Exception {
        SessionManager sessionManager = SessionManagerImpl.getInstance();
        FunctionHandler handler = new FunctionHandler();
        try {
            InputSource source = new InputSource(new StringReader(xml));
            SAXParserUtil.getParser().parse(source, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sessionid = handler.getSessionID();
        Session session = SessionManagerImpl.getInstance().getSession(sessionid);
        
        if (session != null) {
            User user = (User) (session.getAttribute("user"));
            return "<userState><login>" + user.getName() + "</login><MailState>0</MailState><countMessage>2</countMessage><dataRegistration>05.11.2016</dataRegistration></userState>";
        }else{
            return "<error>Session not found</error>";
        }
    }

}
