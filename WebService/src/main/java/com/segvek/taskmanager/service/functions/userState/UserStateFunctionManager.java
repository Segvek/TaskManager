package com.segvek.taskmanager.service.functions.userState;

import com.segvek.taskmanager.service.functions.closeSession.*;
import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.ManagerFunction;

/**
 *
 * @author Panas
 */
public class UserStateFunctionManager implements ManagerFunction{

    @Override
    public boolean isProcesses(String nameTag) {
        return nameTag.equals("userState");
    }

    @Override
    public Function getFunction() {
        return new UserStateFunction();
    }
    
}
