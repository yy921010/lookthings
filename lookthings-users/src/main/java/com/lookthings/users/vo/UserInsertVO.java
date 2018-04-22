package com.lookthings.users.vo;

import com.lookthings.users.model.UserDO;

import java.util.List;

/**
 * Created by Fantasy on 2018/4/22.
 *
 * @author Fantasy
 */
public class UserInsertVO {
    private List<UserDO> userDOS;

    public List<UserDO> getUserDOS() {
        return userDOS;
    }

    public void setUserDOS(List<UserDO> userDOS) {
        this.userDOS = userDOS;
    }

    @Override
    public String toString() {
        return "UserInsertVO{" +
                "userDOS=" + userDOS +
                '}';
    }
}
