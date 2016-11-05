package com.segvek.taskmanager.service.functions.closeSession;

import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.ManagerFunction;

/**
 *
 * @author Panas
 */
public class CloseSessionFunctionManager implements ManagerFunction{

    @Override
    public boolean isProcesses(String nameTag) {
        return nameTag.equals("closeSession");
    }

    @Override
    public Function getFunction() {
        return new CloseSessionFunction();
    }
    
}
