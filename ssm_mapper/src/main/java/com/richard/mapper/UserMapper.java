package com.richard.mapper;

import com.richard.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserMapper {
    List<User> findAllUser();

    User login(User user);

    User register(User user);

    User findUserById(Integer id);

    void updateUser(User user);
}
