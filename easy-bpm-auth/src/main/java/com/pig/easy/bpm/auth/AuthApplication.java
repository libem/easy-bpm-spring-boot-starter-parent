package com.pig.easy.bpm.auth;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.concurrent.CountDownLatch;

//@EnableEasyBpmAuth(scanBasePackages ={"com.pig.easy.bpm.auth.mapper"})
//@SpringBootApplication
//排除配置类, 多数据源定义造成循环依赖
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AuthApplication.class).web(WebApplicationType.NONE).run(args);
		CountDownLatch count = new CountDownLatch(1);
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
