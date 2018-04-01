package com.lookthings.users.dao.basic;

import java.util.List;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @param <T> the type parameter
 * @author Fantasy
 */
public interface BaseDao<T> {

    /**
     * Insert boolean.
     *
     * @param var the var
     * @return the boolean
     */
    Boolean insert(T var);

    /**
     * Delete boolean.
     *
     * @param var the var
     * @return the boolean
     */
    Boolean delete(T var);

    /**
     * Update boolean.
     *
     * @param var the var
     * @return the boolean
     */
    Boolean update(T var);

    /**
     * Select list.
     *
     * @param var the var
     * @return the list
     */
    List<T> select(T var);
}
