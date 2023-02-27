package com.demo.service;

import com.demo.mapper.GoodsMapper;
import com.demo.mapper.UsersMapper;
import com.demo.pojo.Goods;
import com.demo.pojo.Users;
import com.demo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GoodsService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Goods> showlist()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goodsList= goodsMapper.selectAll();
        sqlSession.close();

        return goodsList;
    }

    public List<Goods> showlistbycondition(String name, int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        if (id != 0) {
            List<Goods> goodsList = goodsMapper.selectByCondition(name, id);
            System.out.println(id);
            sqlSession.close();
            return goodsList;
        } else {
            List<Goods> goodsList = goodsMapper.selectByName(name);
            sqlSession.close();
            return goodsList;
        }


    }
    public int add(String name,double price,String description)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        Goods goods=new Goods();
        goods.setName(name);
        goods.setDescription(description);
        goods.setPrice(price);
        try {
            goodsMapper.add(goods);
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
    public int update(Goods goods)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        try {
            goodsMapper.update(goods);
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
    public Goods selectbyid(int id)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
       Goods goods= goodsMapper.selectById(id);
        sqlSession.close();
        return goods;
    }
    public int delete(Goods goods)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GoodsMapper goodsMapper =sqlSession.getMapper(GoodsMapper.class);
        try {
            goodsMapper.del(goods);
            sqlSession.close();
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
      }

    }


}
