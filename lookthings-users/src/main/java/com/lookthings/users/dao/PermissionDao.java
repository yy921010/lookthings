package com.lookthings.users.dao;

import com.lookthings.users.dao.basic.BaseDao;
import com.lookthings.users.model.PermissionDO;
import org.springframework.stereotype.Repository;

/**
 * Created by Fantasy on 2018/1/22.
 *
 * @author Fantasy
 */
@Repository
public interface PermissionDao extends BaseDao<PermissionDO> {
    /**
     * Permission count integer.
     *
     * @return the integer
     */
    Integer permissionCount();
}
