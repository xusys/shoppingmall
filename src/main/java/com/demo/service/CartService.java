package com.demo.service;

import com.demo.mapper.CartMapper;
import com.demo.mapper.GoodsMapper;
import com.demo.pojo.Cart;
import com.demo.pojo.Goods;
import com.demo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

public class CartService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Cart> showlist(int usersid)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        List<Cart> cartList= cartMapper.selectByCondition(usersid,0);
        sqlSession.close();

        return cartList;
    }
    public void add(int usersid,int goodsid, int quantity, double price,String goodsname)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        Cart cart=cartMapper.selectByUG(usersid, goodsid);
        if (cart==null)
        cartMapper.add(usersid,goodsid, price,  quantity,goodsname);
        else {
            quantity=quantity+cart.getQuantity();
            cartMapper.updateUG(usersid,goodsid, price,  quantity,goodsname);}
        sqlSession.close();

    }
    public Cart selectById(int usersid)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        Cart cart= cartMapper.selectById(usersid);
        sqlSession.close();
        return cart;
    }
    public void update(int id, int quantity)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        cartMapper.update(id,quantity);
        sqlSession.close();
    }
    public void del(int id)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        cartMapper.del(id);
        sqlSession.close();
    }
    public void purchase(Cart cart)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        cartMapper.purchase(cart);

        sqlSession.close();
    }
    public List<Cart> showhistory()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        List<Cart> cartList=cartMapper.showhistory();
        sqlSession.close();
        return cartList;
    }

    public List<Cart> showuserhistory(int usersid)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        List<Cart> cartList=cartMapper.showuserhistory(usersid);
        sqlSession.close();
        return cartList;
    }
    public List<Cart> showgoodhistory()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CartMapper cartMapper =sqlSession.getMapper(CartMapper.class);
        List<Cart> cartList=cartMapper.showgoodshistory();
        sqlSession.close();
        return cartList;
    }
}
