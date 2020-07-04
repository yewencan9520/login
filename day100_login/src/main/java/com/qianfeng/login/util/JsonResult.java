package com.qianfeng.login.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    private Integer jsonCode;
    private Object obj;

}
