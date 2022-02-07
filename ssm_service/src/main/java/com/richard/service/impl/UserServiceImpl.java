package com.richard.service.impl;

import com.richard.Md5;
import com.richard.mapper.UserMapper;
import com.richard.pojo.User;
import com.richard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User login(User user) {
        try {
            User user2 = userMapper.login(user);
            if (user2 != null && Md5.verify(user.getPassword(),"richard",user2.getPassword())) {
                return user2;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User register(User user) {
        try {
            List<User> userList = findAllUser();
            for (User user1 : userList) {
                if (user.getAccount() == user1.getAccount()) {
                    return null;
                }
            }
            User user1 = new User();
            user1.setAccountName(user.getAccountName());
            user1.setAccount(user.getAccount());
            String password = Md5.md5(user.getPassword(),"richard");
            user1.setPassword(password);
            user1.setDeptId(user.getDeptId());
            user1.setEmail(user.getEmail());
            user1.setMobile(user.getMobile());
            user1.setTel(user.getTel());
            user1.setSex(user.getSex());
            user1.setBirthday(new Date());
            User register = userMapper.register(user1);
            return register;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        Integer id = user.getId();
        User user1 = findUserById(id);
        if (user1 == null) {
            return false;
        }
        user.setBirthday(new Date());
        userMapper.updateUser(user);
        return true;
    }

}
