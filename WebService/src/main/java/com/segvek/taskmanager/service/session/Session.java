/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.segvek.taskmanager.service.session;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Panas
 */
public interface Session extends Serializable {

    /**
     * Возвращяет идентификатор сесии
     *
     * @return
     */
    public String getIdSession();

    /**
     * Устанавливает произвольный атрибут для сесии данная функция является
     * потокобезопасной
     *
     * @param key   - атрибута
     * @param param - атрибут
     *
     * @return true - если параметр перед етим не біл установлен,
     *         false - если параметр был установлен перед етим однако значение
     *         атрибута заменено
     */
    public boolean setAttribute(String key, Object attribute);

    /**
     * Позволяет получить значение ранее установленого атрибута по ключу
     * В случае получения ссылки на значение атрибута вы берёте на себя
     * ответственность за его потокобезопасность
     *
     * @param key - клуч (название атрибута)
     *
     * @return возвращяет значение атрибута или null в случае если атрибут не
     *         был установлен ранее
     */
    public Object getAttribute(String key);

    /**
     * Позволяет получить колекцию наименований атрибутов в случает если
     * таковые отсутствуют будет возврашенна колекция с 0-елеметов
     *
     * @return
     */
    public Set getAttributeNames();
}
