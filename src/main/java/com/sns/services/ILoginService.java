package com.csi.services;

import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 21:31
 * @Version 1.0.0
 */
public interface ILoginService {

    /**
     * 登录
     * @param model
     * @param
     * @return
     * @throws Exception
     */
    public String login(Model model,
                        String userName, String password) throws  Exception;

    /**
     * 注销
     * @param model
     * @param session
     * @param sessionStatus
     * @return
     * @throws Exception
     */
    public String logout(Model model, HttpSession session, SessionStatus sessionStatus) throws Exception;
}
