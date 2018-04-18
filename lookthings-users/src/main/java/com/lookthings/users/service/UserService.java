package com.lookthings.users.service;


import com.lookthings.users.model.UserDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author Fantasy
 */
public interface UserService {

    /**
     * Gets com.lookthings.users by user info.
     *
     * @param u the u
     * @return the com.lookthings.users by user info
     */
    List<UserDO> getUsersByUserInfo(UserDO u);

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
    Boolean deleteUserByUserInfo(int[] u);

    /**
     * Update user by user info boolean.
     *
     * @param u the u
     * @return the boolean
     */
    Boolean updateUserByUserInfo(List<UserDO> u);
}
