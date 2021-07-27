package com.csi.services;

import com.csi.database.data.CsiUser;
import org.springframework.ui.Model;

/**
 * 用户管理服务接口
 * @Author ZYF
 * @CreateTime 2021/7/25 20:00
 * @Version 1.0.0
 */
public interface IUserService {
    /**
     * 查询用户数据
     * @param model
     * @param userName
     * @return
     * @throws Exception
     */
    public String query(Model model, String userName) throws Exception;

    /**
     * 展示添加视图
     * @param model
     *
     * @return
     * @throws Exception
     */
    public String addview(Model model) throws Exception;

    /**
     * 展示修改视图
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    public String updateview(Model model, Integer id) throws Exception;

    /**
     * 添加用户数据
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    public String add(Model model, CsiUser user) throws Exception;

    /**
     * 修改用户数据
     * @param model
     * @param user
     * @return
     * @throws Exception
     */
    public String update(Model model, CsiUser user) throws Exception;

    /**
     * 删除用户数据
     * @param model
     * @param ids
     * @return
     * @throws Exception
     */
    public String delete(Model model, String ids) throws Exception;
}
