package com.lookthings.users.dao;

import com.lookthings.users.dao.basic.BaseDao;
import com.lookthings.users.model.RoleDO;
import org.springframework.stereotype.Repository;

/**
 * Created by Fantasy on 2018/1/22.
 *
 * @author Fantasy
 */
@Repository
public interface RoleDao extends BaseDao<RoleDO> {
    /**
     * Role count integer.
     *
     * @return the integer
     */
    Integer roleCount();
}
