package com.junhan.big_event.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
 //建立分組校驗，因為add和update都需要使用該類，但add不需要id，因此需要進行分組校驗
    @NotNull(groups = update.class)
    private Integer id;//主鍵ID
    @NotEmpty
    private String categoryName;//分類名稱
    @NotEmpty
    private String categoryAlias;//分類別名
    private Integer createUser;//創建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//創建時間
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新時間
    //如果沒有設定校正分組則默認為Default
    //分組之間可透過繼承A extends B，那麼A中，擁有B中所有校正項目
    public interface add extends Default {
    }

    public interface update extends Default {
    }
}
