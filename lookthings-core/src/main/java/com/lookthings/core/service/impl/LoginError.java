package com.lookthings.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Fantasy on 2018/6/3.
 *
 * @author Fantasy
 */
@Component("LoginError")
public class LoginError {
    @Value("${errorCode.login.account}")
    private String account;

    @Value("${errorCode.login.password}")
    private String password;

    @Value("${errorCode.login.lock}")
    private String lock;

    @Value("${errorCode.login.other}")
    private String other;

    @Value("${errorCode.login.email}")
    private String email;

    @Value("${errorCode.login.emailValid}")
    private String emailValid;

    @Value("${errorCode.login.logout}")
    private String logout;


    /**
     * Gets account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets other.
     *
     * @return the other
     */
    public String getOther() {
        return other;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets enamil valid.
     *
     * @return the enamil valid
     */
    public String getEmailValid() {
        return emailValid;
    }

    /**
     * Gets logout.
     *
     * @return the logout
     */
    public String getLogout() {
        return logout;
    }
}
