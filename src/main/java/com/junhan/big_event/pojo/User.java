package com.junhan.big_event.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
//lombok，自動生成getter, setter, to String
//pom中引入依賴，實體類中加入註解
@Data
public class User {
    @NotNull
    private Integer id;//主鍵id
    private String username;//用戶名稱
    @JsonIgnore //讓spring mvc把物件轉換為json時忽略，最終的json字串就不會存在password
    private String password;//密碼
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//暱稱
    @NotEmpty
    @Email
    private String email;//郵箱
    private String userPic;//用戶頭像地址
    private LocalDateTime createTime;//創建時間
    private LocalDateTime updateTime;//更新時間
}
