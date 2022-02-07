package com.richard.controller;

import com.github.pagehelper.PageInfo;
import com.richard.pojo.ResponseResult;
import com.richard.pojo.User;
import com.richard.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser")
    public ResponseResult findAllUser() {

        try {
            List<User> userList = userService.findAllUser();
            return new ResponseResult(true,200,"查询成功",userList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/login")
    public ResponseResult login(User user,  HttpServletRequest request) {
        try {

            User user2 = userService.login(user);
            if (user2 != null) {

                Map<String,Object> map = new HashMap<>();
                String access_token = UUID.randomUUID().toString();
                map.put("access_token",access_token);
                map.put("user_id",user2.getId());

                HttpSession session = request.getSession();
                session.setAttribute("user_id",user2.getId());
                session.setAttribute("access_token",access_token);

                return new ResponseResult(true,200,"登录成功",user2.getId());
            } else {
                return new ResponseResult(true,400,"用户名密码错误",null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        try {
            User user1 = userService.register(user);
            if (user1 == null) {
                return new ResponseResult(true,200,"添加失败","账户已存在");
            }
            List<User> userList = userService.findAllUser();
            return new ResponseResult(true,200,"添加成功",userList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user) {
        try {
            boolean flag = userService.updateUser(user);
            if (flag) {
                User user1 = userService.findUserById(user.getId());
                return new ResponseResult(true,200,"修改成功",user1);
            } else {
                return new ResponseResult(true,200,"修改失败","不存在此账户");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    @Test
//    public void test() {
//        User user = new User();
//        user.setAccountName("1321321");
//        user.setBirthday(new Date());
//        user.setAccount("132132");
//        user.setTel("1234213");
//        user.setSex(1);
//        user.setDeptId(2);
//        user.setMobile("123123423");
//        user.setEmail("1234213@qq.com");
//        user.setPassword("123123");
//        User register = userService.register(user);
//
//    }
}
