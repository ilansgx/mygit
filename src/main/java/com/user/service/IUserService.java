package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface IUserService {
    public User queryById(Long id);

    public List<User> queryByCondition(User user);

    public void saveOrUpdateUser(User user);

    public void deteteUser(Long id);
}
