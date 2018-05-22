package com.lookthings.users.service;


import com.github.pagehelper.PageInfo;
import com.lookthings.users.model.UserDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author Fantasy
 */
public interface UserService {

    /**
     * Gets all users.
     *
     * @param u        the u
     * @param pageNo   the page no
     * @param pageSize the page size
     * @return the all users
     */
    PageInfo<UserDO> getUsersByPageIndex(UserDO u, Integer pageNo, Integer pageSize);

    /**
     * Gets users by page index.
     *
     * @param u the u
     * @return the users by page index
     */
    List<UserDO> getUsersByPageIndex(UserDO u);

    /**
     * Insert user by user info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean insertUserByUserInfo(List<UserDO> u);

    /**
     * Delete user by user info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean deleteUserByUserInfo(List<Integer> u);

    /**
     * Update user by user info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updateUserByUserInfo(List<UserDO> u);

    /**
     * Find user model by user name user do.
     *
     * @param userName the user name
     * @return the user do
     */
    UserDO findUserModelByUserName(String userName);
}
