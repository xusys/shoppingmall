package com.demo.mapper;

import com.demo.pojo.Goods;
import com.demo.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<Goods> selectAll();
    Goods selectById(int id);
    List<Goods> selectByCondition(@Param("name") String name, @Param("id") int id);
    List<Goods> selectByName(@Param("name") String name);
    void update(Goods goods);
    void del(Goods goods);
    int dels(int[] ints);

    void add(Goods goods);
}
