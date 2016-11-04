/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service;

/**
 *
 * @author Panas
 */
public interface ManagerFunctions {

    public boolean isProcesses(String nameTag);

    public Function getFunction(String nameTag) throws Exception;
}
