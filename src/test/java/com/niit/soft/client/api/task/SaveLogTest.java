package com.niit.soft.client.api.task;

import com.niit.soft.client.api.repository.LogInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SaveLogTest {
    @Resource
    private LogInfoRepository logInfoRepository;
    @Test
    void test(){
        String str = "2020-05-30 08:51:28.708  INFO 22128 --- [http-nio-8080-exec-9] c.n.soft.client.api.aspect.WebLogAspect  : 请求方法：POST**1**\n".trim();
        System.out.println("******************************");
        System.out.println(str.substring(0,24));
        System.out.println(str.split("---")[1].split(":")[0].trim());
        System.out.println(str.split(":")[3].replace("**1**",""));
        System.out.println();
        System.out.println();
        System.out.println("******************************");
    }

}