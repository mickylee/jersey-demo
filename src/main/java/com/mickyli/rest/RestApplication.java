package com.mickyli.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//Java config 方式
//@ApplicationPath("/")
public class RestApplication extends ResourceConfig {  
    public RestApplication() {  
        //服务类所在的包路径  
        packages("com.mickyli.rest.resources");  
        //注册JSON转换器  -- pom引入jackson-all
        //register(JacksonJsonProvider.class);  
      
       }  
}
