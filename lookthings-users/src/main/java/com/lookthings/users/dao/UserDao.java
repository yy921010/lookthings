package com.lookthings.users.dao;

import com.lookthings.users.dao.basic.BaseDao;
import com.lookthings.users.model.UserDO;
import org.springframework.stereotype.Repository;

/**
 * Created by Fantasy on 2018/1/19.
 *
 * @author yy
 */
@Repository
public interface UserDao extends BaseDao<UserDO> {

    /**
     * Find user model by user name user do.
     *
     * @param userName the user name
     * @return the user do
     */
    UserDO findUserModelByUserName(String userName);
}
