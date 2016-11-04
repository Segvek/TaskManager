/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.functions.registration;
import com.segvek.taskmanager.service.Function;
import com.segvek.taskmanager.service.ManagerFunction;
/**
 *
 * @author Panas
 */
public class RegistrationFunctionManager implements ManagerFunction{

    @Override
    public boolean isProcesses(String nameTag) {
        return nameTag.equals("registration");
    }

    @Override
    public Function getFunction() {
        return new FunctionRegistration();
    }
    
}
