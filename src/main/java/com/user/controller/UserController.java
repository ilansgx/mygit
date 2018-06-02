package com.user.controller;

import com.user.entity.User;
import com.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("userController")
@RequestMapping("usercontroller")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(ModelMap model){
        List<User> uList = userServiceImpl.queryByCondition(null);
        model.put("list",uList);
        return "/index";
    }

    @RequestMapping(value = "linkToOperate",method = RequestMethod.GET)
    public String linkToOperate(@RequestParam(required = false) Long id, ModelMap model){
        if(id != null){
            User user = userServiceImpl.queryById(id);
            model.put("user",user);
        }

        return "/add";
    }

    @RequestMapping(value = "operate",method = RequestMethod.POST)
    public String operate(User user, ModelMap model){
        if(user != null){
            userServiceImpl.saveOrUpdateUser(user);
        }
        List<User> uList = userServiceImpl.queryByCondition(null);
        model.put("list",uList);
        return "/index";
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(@RequestParam String id, ModelMap model){
        userServiceImpl.deteteUser(Long.valueOf(id));
        List<User> uList = userServiceImpl.queryByCondition(null);
        model.put("list",uList);
        return "/index";
    }
}
