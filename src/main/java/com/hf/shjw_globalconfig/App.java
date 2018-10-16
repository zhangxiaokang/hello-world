package com.hf.shjw_globalconfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * zhangxiaokang
 *
 */
@SpringBootApplication
@MapperScan("com.hf.shjw_globalconfig.dao")
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
