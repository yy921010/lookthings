package com.lookthings.users.controller;


import com.lookthings.users.vo.JsonResult;

import java.util.List;

/**
 * Created by Fantasy on 2018/2/4.
 *
 * @param <T> the type parameter
 * @author Fantasy
 */
public interface BaseOperationController<T> {

    /**
     * Select json result.
     *
     * @param id the id
     * @return the json result
     */
    JsonResult<List<T>> select(String id);

    /**
     * Insert json result.
     *
     * @param t the t
     * @return the json result
     */
    JsonResult<String> insert(T t);

    /**
     * Update json result.
     *
     * @param t the t
     * @return the json result
     */
    JsonResult<String> update(T t);

    /**
     * Delete json result.
     *
     * @param t the t
     * @return the json result
     */
    JsonResult<String> delete(T t);
}
