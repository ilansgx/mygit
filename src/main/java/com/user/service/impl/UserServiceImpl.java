package com.user.service.impl;

import com.user.dao.UserDao;
import com.user.entity.User;
import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> queryByCondition(User user) {
        return userDao.getByCondition(user);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        if(user.getId()!=null){
            userDao.update(user);
        }else{
            userDao.insert(user);
        }
    }

    @Override
    public void deteteUser(Long id) {
        userDao.delete(id);
    }
}
