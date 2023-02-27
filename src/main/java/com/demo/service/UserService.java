package com.demo.service;

import com.demo.mapper.UsersMapper;
import com.demo.pojo.Users;
import com.demo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public Users Login(String username,String password){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UsersMapper usersMapper =sqlSession.getMapper(UsersMapper.class);
        List<Users> usersList= usersMapper.selectByCondition(username,password);
        sqlSession.close();
        if(usersList.isEmpty())
            return null;
        else return usersList.get(0);

    }
    public Users Register(String username,String password, String email)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        int id = 0;
        Users users=new Users();
        users.setUsername(username);
        users.setPassword(password);
        users.setEmail(email);
        try {
           usersMapper.add(users);
            sqlSession.close();
           id= users.getId();
           return users;
        }catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }



    }
}
