/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.util;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Panas
 */
public class InputStreamUtil {
    public static String readInputStrean(InputStream stream) throws IOException {
        String result = "";
        int temp;
        while ((temp = stream.read()) != -1) {
            result += (char) temp;
        }
        return result;
    }
}
