package com.csi.services;

import com.csi.database.data.CsiUser;
import com.csi.database.mapper.ICsiUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理的服务接口具体实现类
 * @Author ZYF
 * @CreateTime 2021/7/25 20:03
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl implements  IUserService{
        //注入数据访问映射接口
        @Resource
        private ICsiUserMapper iuserMapper;

        @Override
        public String query(Model model, String userName) throws Exception {
            //调用数据访问接口的查询方法
            List<CsiUser> list = iuserMapper.queryAllUser(userName);
            //封装数据到模型中
            model.addAttribute("list", list);
            return "admin/user/userlist";
        }

        @Override
        public String add(Model model, CsiUser user) throws Exception {
            //调用数据接口的添加方法
            iuserMapper.addUser(user);
            //查询用户数据更新用户列表
            return query(model, null);
        }



        @Override
        public String update(Model model, CsiUser user) throws Exception {
            iuserMapper.updateUser(user);
            return query(model, null);
        }

        @Override
        public String delete(Model model, String ids) throws Exception {
            iuserMapper.deleteUser(ids);
            return query(model, null);
        }

        @Override
        public String updateview(Model model, Integer id) throws Exception {
            CsiUser user = iuserMapper.queryByIdUser(id);
            model.addAttribute("user", user);
            return "admin/user/userupdateview";
        }

        @Override
        public String addview(Model model) throws Exception {
            return "admin/user/useraddview";
        }
}
