/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service;

/**
 * Реализация даного интерфейса будет являтся фасадом для всей системы
 *
 * @author Panas
 */
public interface ParserManager {

    /**
     * Данный метод будет обрабатывать запрос и возврашать результат
     * более детальнее структура запроса и ответов описана в xsd схемах проекта
     * @param xml - document (request)
     *
     * @return xml - document(responce)
     *
     */
    public String parse(String xml);
}
