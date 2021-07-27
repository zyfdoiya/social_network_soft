package com.csi.controllers;

/**
 * 用户管理控制器
 * @Author ZYF
 * @CreateTime 2021/7/25 21:24
 * @Version 1.0.0
 */

import com.csi.database.data.CsiUser;
import com.csi.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    //注入服务接口对象
    @Resource
    private IUserService iUserService;

    /**
     * 查询用户数据
     * @param model
     * @param suserName
     * @return
     */
    @RequestMapping("/user/query")
    public  String query(Model model, String suserName){
        try{
            String  nextPath = iUserService.query(model, suserName);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 展示添加用户视图
     * @param model
     * @return
     */
    @RequestMapping("/user/addview")
    public String addView(Model model){
        try{
            String  nextPath = iUserService.addview(model);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 展示修改用户视图
     * @param model
     * @return
     */
    @RequestMapping("/user/updateview/{id}")
    public String updateView(Model model, @PathVariable("id") Integer id) {
        try{
            String  nextPath = iUserService.updateview(model, id);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 添加用户
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/user/add")
    public String add(Model model, CsiUser user){
        try{
            String  nextPath = iUserService.add(model, user);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 修改用户
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/user/update/{id}")
    public String update(Model model, CsiUser user, @PathVariable("id") Integer id){
        try{
            user.setUserId(id);
            String  nextPath = iUserService.update(model, user);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    /**
     * 删除用户
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/user/delete")
    public String delete(Model model, String id){
        try{
            String  nextPath = iUserService.delete(model, id);
            return nextPath;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
