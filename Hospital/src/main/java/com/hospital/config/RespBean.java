package com.hospital.config;

import org.springframework.web.bind.annotation.ResponseBody;

public class RespBean {
    @ResponseBody
    public static RespBean ok(String s, Object principal) {
        return RespBean.ok("1"+s+principal);
    }
    @ResponseBody
    public static RespBean ok(String s) {
        return RespBean.ok("1"+s);
    }
    @ResponseBody
    public static RespBean error(String s) {
        return RespBean.ok("-1"+s);
    }

}
