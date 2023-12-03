package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    public boolean update(User user) {
        return userDao.update(user) > 0;
    }

    public boolean delete(Integer User_id) {
        return userDao.delete(User_id) > 0;
    }



    public User loginInService(String userAccount, String userPsw,boolean userAd){
        User user = userDao.getByAccountancyUsurps(userAccount,userPsw,userAd);
        return user;
    }

    @Override
    public User registerService(User user) {
        if(userDao.findByaccount(user.getUserAccount())!=null){
            return null;
        }
        else {
            userDao.save(user);
            user.setUserName(user.getUserAccount()+"name");
            return user;
        }
    }


}