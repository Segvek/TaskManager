/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.util;

/**
 *
 * @author Panas
 */
public class RandomHexCode {

    public static String getHex(){
        return getHex(15);
    }
    
    public static String getHex(int sizeHexCode) {
        String symbols = "1234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder randString = new StringBuilder();
        for (int i = 0; i < sizeHexCode; i++) {
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randString.toString();
    }
}
