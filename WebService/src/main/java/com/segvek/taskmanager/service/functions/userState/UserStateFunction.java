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
        
        StringBuilder responce = new StringBuilder();
        
        if (session != null) {
            User user = (User) (session.getAttribute("user"));
            responce.append("<userState><login>" + user.getName() + "</login><dataRegistration>"+user.getDateRegistration()+"</dataRegistration>");
            responce.append("<warnings>");
            if(!"true".equals(user.getConfirmation())){
                responce.append("<warning><content>Уважаемый пользователь, для избежания "
                        + "и корректного разрешения непредвиденных ситуаций. Просим незамедлительно"
                        + " подтвердить свой почтовый адресс.</content>"
                        + "<title>Подтверждение почтового адреса.</title></warning>");
            }
            responce.append("</warnings>");
            responce.append("<countMessage>2</countMessage>");
            responce.append("</userState>");
        }else{
            responce.append("<error>Session not found</error>");
        }
        return responce.toString();
    }

}
