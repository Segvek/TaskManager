package com.segvek.taskmanager.service.functions.creategoal;

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

public class CreateGoalFunction implements Function {

    @Override
    public String processes(String xml) throws Exception {
        FunctionHandler handler = new CreateGoalHandler();
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
            hses.beginTransaction();
            User user = (User) hses.get(User.class, (Long)session.getAttribute("user"));
            Goal goal = ((CreateGoalHandler) handler).getGoal();
            goal.setUser(user);
            user.getGoals().add(goal);
            hses.save(goal);
            hses.getTransaction().commit();
            hses.close();
            responce.append("<createGoal>ok</createGoal>");
        } else {
            responce.append("<error>Session not found</error>");
        }
        return responce.toString();
    }

}
