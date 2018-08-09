package com.scau.hyskjf.util.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by supiccc on 2018-08-08 01:08
 */
@WebServlet(urlPatterns = "/druid/*", initParams={
        @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
        @WebInitParam(name="loginUsername",value="admin"),// 用户名
        @WebInitParam(name="loginPassword",value="admin"),// 密码
        @WebInitParam(name="resetEnable",value="true")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 2359758657306626394L; // 给定序列化ID
}
