package com.segvek.taskmanager.service.functions.goalinfo;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.model.Goal;
import com.segvek.taskmanager.service.model.ItemGoalPlan;
import com.segvek.taskmanager.service.model.User;
import com.segvek.taskmanager.service.session.Session;
import com.segvek.taskmanager.service.session.impl.SessionManagerImpl;
import com.segvek.taskmanager.service.util.HibernateUtil;
import com.segvek.taskmanager.service.util.SAXParserUtil;
import java.io.StringReader;
import java.util.List;
import org.xml.sax.InputSource;

public class GoalInfoFunction implements Function {

    @Override
    public String processes(String xml) throws Exception {
        GoalInfoHandler handler = new GoalInfoHandler();
        StringBuilder responce = new StringBuilder();
        try {
            InputSource source = new InputSource(new StringReader(xml));
            SAXParserUtil.getParser().parse(source, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sessionid = handler.getSessionID();
        String goalId = handler.getGoalId();
        Session session = SessionManagerImpl.getInstance().getSession(sessionid);
        Long gi;
        try {
            gi = Long.parseLong(goalId);
        } catch (NumberFormatException e) {
            responce.append("<error>error goal id format!</error>");
            return responce.toString();
        }
        if (session != null) {
            org.hibernate.Session hses = HibernateUtil.getSessionFactory().openSession();
            hses.beginTransaction();
            
            User user = (User) hses.get(User.class, (Long) session.getAttribute("user"));
            List<Goal> goals = user.getGoals();
            Goal goal = (Goal) hses.get(Goal.class, gi);
            
            for (Goal g : goals) {
                if (g.getId().equals(gi)) {
                    return createXMLResponce(goal);
                }
            }
            
            responce.append("<error>goal not found</error>");
            
            hses.getTransaction().rollback();
            hses.close();
        } else {
            responce.append("<error>Session not found</error>");
        }
        return responce.toString();
    }

    private String createXMLResponce(Goal goal) {
        StringBuilder responce = new StringBuilder();
        responce.append("<goalInfo><name>")
                .append(goal.getName()).append("</name><annotation>")
                .append(goal.getAnnotation()).append("</annotation><beginDate>")
                .append(goal.getStartDate()).append("</beginDate><endDate>")
                .append(goal.getEndDate()).append("</endDate><state>")
                .append(goal.getState()).append("</state><plan>");
        for (ItemGoalPlan igp : goal.getItemGoalPlan()) {
            responce.append("<item><id>")
                    .append(igp.getId()).append("</id><name>")
                    .append(igp.getName()).append("</name><annotation>")
                    .append(igp.getAnotattion()).append("</annotation><beginDate>")
                    .append(igp.getStartDate()).append("</beginDate><endDate>")
                    .append(igp.getEndDate()).append("</endDate><state>")
                    .append(igp.getState()).append("</state></item>");
        }
        responce.append("</plan></goalInfo>");
        return responce.toString();
    }

}
