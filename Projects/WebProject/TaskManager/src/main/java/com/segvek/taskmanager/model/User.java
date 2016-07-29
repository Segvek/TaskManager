/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.model;

import java.util.List;

/**
 *
 * @author Panas
 */
public interface User {

    public void addSetting(Setting setting, SettingValue value);

    public boolean isSetting(String name);

    public SettingValue getSettingValue(String nameSetting);

    public List<SettingValue> getSettingValues();

}
