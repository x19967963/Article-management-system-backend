package com.junhan.big_event.controller;

import com.junhan.big_event.pojo.Result;
import com.junhan.big_event.pojo.User;
import com.junhan.big_event.service.UserService;
import com.junhan.big_event.utils.JwtUtil;
import com.junhan.big_event.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$")String username, @Pattern(regexp = "^\\S{5,16}$")String password) {
        //查看用戶
        User user =  userService.findByUserName(username);
        if(user == null){
            //若用用戶不存在就註冊
            userService.register(username, password);
            return Result.success();
        }else{
            return Result.error("用戶名已被使用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$")String username, @Pattern(regexp = "^\\S{5,16}$")String password){
        //根據用戶名查詢用戶
        User loginUser =  userService.findByUserName(username);
        //判斷該用戶是否存在
        if(loginUser == null){
            return Result.error("用戶名錯誤");
        }
        //判斷密碼是否正確
        if(loginUser.getPassword().equals(password)){
            //生成jwt token令牌
            Map<String,Object> map = new HashMap<>();
            map.put("id",loginUser.getId());
            map.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(map);
            return Result.success(token);
        }
        return Result.error("密碼錯誤");



    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        //根據用戶名查詢用戶，從攔截器的ThreadLocal中取得使用者名字
        Map<String, Object> map =  ThreadLocalUtil.get();
        User user = userService.findByUserName(map.get("username").toString());
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvater")
    public Result updateAvatar(@RequestParam @URL String avaterUrl){
        userService.updateAvater(avaterUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //校驗參數
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String rePwd = params.get("rePwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要的參數");
        }

        //原密碼是否正確
        //調用UserService，根據用戶名稱取的密碼與oldPwd比對
        Map<String,Object> map= ThreadLocalUtil.get();
        User user = userService.findByUserName(map.get("username").toString());
        if(!user.getPassword().equals(oldPwd)){
            return Result.error("原密碼不正確");
        }

        //newPwd與rePwd是否相同
        if(!rePwd.equals(newPwd)){
            return Result.error("兩次填寫密碼不同");
        }

        //調用UserService完成密碼更新
        userService.updatePwd(newPwd);
        return Result.success();


    }


}
