/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.creategoal;

import com.segvek.taskmanager.service.functions.FunctionHandler;
import com.segvek.taskmanager.service.model.Goal;
import com.segvek.taskmanager.service.model.ItemGoalPlan;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Panas
 */
public class CreateGoalHandler extends FunctionHandler {

    private String thisElement = "";
    private Goal goal = new Goal();
    private ItemGoalPlan igp;

    private boolean thisItem = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        thisElement = qName;
        if (thisElement.equals("item")) {
            igp = new ItemGoalPlan();
            igp.setGoal(goal);
            thisItem = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        if (qName.equals("item") && thisItem) {
            goal.getItemGoalPlan().add(igp);
            thisItem = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        switch (thisElement) {
            case "name":
                if (thisItem) {
                    igp.setName(new String(ch, start, length));
                    break;
                }
                if (goal.getName() == null) {
                    goal.setName(new String(ch, start, length));
                }
                break;
            case "anotation":
                if (goal.getAnnotation() == null) {
                    goal.setAnnotation(new String(ch, start, length));
                }
                break;
            case "beginDate":
                if (thisItem) {
                    igp.setStartDate(new String(ch, start, length));
                    break;
                }
                if (goal.getStartDate() == null) {
                    goal.setStartDate(new String(ch, start, length));
                }
                break;
            case "endDate":
                if (thisItem) {
                    igp.setEndDate(new String(ch, start, length));
                    break;
                }
                if (goal.getEndDate() == null) {
                    goal.setEndDate(new String(ch, start, length));
                }
                break;
            case "idAcount":
                //todo связать со счётом
                break;
        }

    }

    public Goal getGoal() {
        return goal;
    }

}
