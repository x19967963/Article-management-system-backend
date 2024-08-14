package com.junhan.big_event.service.impl;

import com.junhan.big_event.mapper.UserMapper;
import com.junhan.big_event.pojo.User;
import com.junhan.big_event.service.UserService;
import com.junhan.big_event.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void register( String username,String password) {
        //密碼加密
//        String md5String =  Md5Util.getMD5String(password);
        // 添加
        userMapper.add(username,password);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvater(String avaterUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = Integer.parseInt(map.get("id").toString());
        userMapper.updateAvater(avaterUrl, id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = Integer.parseInt(map.get("id").toString());
        userMapper.updatePwd(newPwd, id);
    }
}
