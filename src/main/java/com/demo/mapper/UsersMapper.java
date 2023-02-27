package com.demo.mapper;

import com.demo.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    List<Users> selectAll();
    Users selectById(int id);
    List<Users> selectByCondition(@Param("username") String username,@Param("password") String password);

    void add(Users users);

}
