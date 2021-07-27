package com.csi.services;

import com.csi.database.data.CsiUser;
import com.csi.database.mapper.ICsiUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author ZYF
 * @CreateTime 2021/7/25 21:33
 * @Version 1.0.0
 */
@Service
public class LoginServiceImpl implements ILoginService {

    //注入数据访问映射接口对象
    @Resource
    private ICsiUserMapper iuserMapper;


    @Override
    public String login(Model model,
                        String userName, String password) throws Exception {
        //访问数据映射接口，条件查询数据
        CsiUser user = iuserMapper.queryByLogin(userName, password);
        //用户登录验证
        if (user!=null){//登录成功
            //封装数据到会话缓存中
            model.addAttribute( "user",user);
            return "index";
        }else {//登录事件
            model.addAttribute("error","用户名密码错误");
        }

        return "login";
    }

    @Override
    public String logout(Model model, HttpSession session,
                         SessionStatus sessionStatus) throws Exception {
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
