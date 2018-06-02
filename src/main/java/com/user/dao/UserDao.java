package com.user.dao;

import com.user.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userDao")
public class UserDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public User getById(Long id){
        return sqlSessionTemplate.selectOne("com.user.mappers.UserMapper.getUserById",id);
    }

    public List<User> getByCondition(User user){
        return sqlSessionTemplate.selectList("com.user.mappers.UserMapper.getByCondition",user);
    }

    public void insert(User user){
        sqlSessionTemplate.insert("com.user.mappers.UserMapper.insert",user);
    }

    public void update(User user){
        sqlSessionTemplate.update("com.user.mappers.UserMapper.update",user);
    }

    public void delete(Long id){
        sqlSessionTemplate.delete("com.user.mappers.UserMapper.delete",id);
    }
}
