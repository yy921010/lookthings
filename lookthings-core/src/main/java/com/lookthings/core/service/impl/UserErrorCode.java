package com.lookthings.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Fantasy on 2018/5/23.
 *
 * @author Fantasy
 */
@Component("userErrorCode")
public class UserErrorCode {
    @Value("${user.error.account}")
    private String AccountError;

    @Value("${user.error.mailValid}")
    private String userMailValid;

    public String getAccountError() {
        return AccountError;
    }

    public String getMailValidError() {
        return userMailValid;
    }
}
