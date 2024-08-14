package com.junhan.big_event.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分頁回傳結果物件
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T>{
    private Long total;//總條數
    private List<T> items;//當前頁面數據集合
}
