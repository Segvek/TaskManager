/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.session;

/**
 *
 * @author Panas
 */
public interface SessionManager {

    /**
     * Позволяет получить ссылку на сесию
     *
     * @param id - идентфикатор сесии
     *
     * @return возврашяет null в случае отсутсвия запрашиваемой сесии
     */
    public Session getSession(String id);

    /**
     * Позволяет создать новую сеиию
     *
     * @return возвращяет идентификатор (id) к только что созданой сесии
     */
    public Session createSession();

    /**
     * Позволяет закрыть сесию по id
     *
     * @param id - идентфикатор сесии
     *
     * @return возврашяет false в случае отсутсвия запрашиваемой сесии
     */
    public boolean closeSession(String id);
}
