package com.junhan.big_event.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.junhan.big_event.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
//lombok，自動生成getter, setter, to String
//pom中引入依賴，實體類中加入註解
@Data
public class Article {
    @NotNull(groups = Article.update.class)
    private Integer id;//主鍵ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;//文章標題
    @NotEmpty
    private String content;//文章內容
    @NotEmpty
    @URL
    private String coverImg;//封面圖像
    @State
    private String state;//發布狀態 已方部|草稿
    @NotNull
    private Integer categoryId;//文章分類id
    private Integer createUser;//創建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//創建時間
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新時間
    public interface add extends Default {
    }

    public interface update extends Default {
    }
}
