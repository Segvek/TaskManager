package com.segvek.taskmanager.service.impl;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.ManagerFunction;
import com.segvek.taskmanager.service.ManagerFunctions;
import com.segvek.taskmanager.service.functions.authorization.AuthorizationFunctionManager;
import com.segvek.taskmanager.service.functions.closeSession.CloseSessionFunctionManager;
import com.segvek.taskmanager.service.functions.creategoal.CreateGoalFunctionManager;
import com.segvek.taskmanager.service.functions.goalinfo.GoalInfoFunctionManager;
import com.segvek.taskmanager.service.functions.registration.FunctionConfirmationRegistrationManager;
import com.segvek.taskmanager.service.functions.registration.RegistrationFunctionManager;
import com.segvek.taskmanager.service.functions.userGoals.UserGoalsFunctionManager;
import com.segvek.taskmanager.service.functions.userState.UserStateFunctionManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Panasenco
 */
public class ManagerFunctionsImpl implements ManagerFunctions {

    Set<ManagerFunction> managersFunction;

    public ManagerFunctionsImpl() {
//        Object tempObj = SpringUtil.getInstance().getBean("managersFunction");
//        if (tempObj instanceof Set) {
//            managersFunction = (Set<ManagerFunction>) tempObj;
//        } else {
//            throw new ExceptionInInitializerError("НЕ соответствие типов");
//        }
        managersFunction = new HashSet<>();
        managersFunction.add(new AuthorizationFunctionManager());
        managersFunction.add(new RegistrationFunctionManager());
        managersFunction.add(new FunctionConfirmationRegistrationManager());
        managersFunction.add(new CloseSessionFunctionManager());
        managersFunction.add(new UserStateFunctionManager());
        managersFunction.add(new CreateGoalFunctionManager());
        managersFunction.add(new UserGoalsFunctionManager());
        managersFunction.add(new GoalInfoFunctionManager());
    }

    @Override
    public boolean isProcesses(String nameTag) {
        Iterator iterator = managersFunction.iterator();
        while (iterator.hasNext()) {
            if (((ManagerFunction) iterator.next()).isProcesses(nameTag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Function getFunction(String nameTag) throws Exception {
        Iterator iterator = managersFunction.iterator();
        while (iterator.hasNext()) {
            ManagerFunction manager = (ManagerFunction) iterator.next();
            if (manager.isProcesses(nameTag)) {
                return manager.getFunction();
            }
        }
        return null;
    }

}
