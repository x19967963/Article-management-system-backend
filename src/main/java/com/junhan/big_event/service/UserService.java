package com.junhan.big_event.service;

import com.junhan.big_event.pojo.User;

public interface UserService {
    //根據用戶名查詢用戶
    User findByUserName(String username);
    //註冊
    void register(String username, String password);
    //更新用戶資訊
    void update(User user);
    //更新頭像
    void updateAvater(String avaterUrl);
    //更新密碼
    void updatePwd(String newPwd);
}
