/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.closeSession;
import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.functions.FunctionHandler;
import com.segvek.taskmanager.service.session.SessionManager;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import java.io.StringReader;
import org.xml.sax.InputSource;
/**
 *
 * @author Panas
 */
public class CloseSessionFunction implements Function{

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
        String status="ok";
        if(sessionManager.getSession(sessionid)==null)
            status="session not found";
        else
            sessionManager.closeSession(sessionid);
        return "<closeSession>"+status+"</closeSession>";
    }
    
}
