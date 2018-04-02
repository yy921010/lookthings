package com.lookthings.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Fantasy on 2018/3/7.
 *
 * @author Fantasy
 */
@Component("commonConfig")
public class CommonConfig {

    @Value("${config.isaKey}")
    private String isaKey;

    @Value("${config.doubankey}")
    private String doubanKey;

    @Value("${config.juheKey}")
    private String juheKey;

    @Value("${config.oneUuid}")
    private String oneUuid;

    public String getIsaKey() {
        return isaKey;
    }

    public String getDoubanKey() {
        return doubanKey;
    }

    public String getJuheKey() {
        return juheKey;
    }

    public String getOneUuid() {
        return oneUuid;
    }
}
