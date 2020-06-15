package com.niit.soft.client.api.service;

import com.niit.soft.client.api.util.JobJSoup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class JobTypeServiceTest {

    @Resource
    private JobTypeService jobTypeService;

    @Resource
    private JobJSoup jobTypeJSoup;



    @Test
    void addJobType() {

        jobTypeService.saveBatch(jobTypeJSoup.getData());
//        System.out.println(list);
    }


    @Test
    void findType() {
        jobTypeService.findType().forEach(System.out::println);
    }

//        jobTypeService.saveBatch(JobJSoup.getData());
//        String a1 [] = {"Python", "Android", "IT运维/安全", "iOS", "测试", "大数据开发", "自然语言处理",
//                "收搜/广告/推荐算法", "数据挖掘/机器学习", "Java", "PHP", "C#/.NET", "web前端", "C/C++",
//                "Golang", "U3D/COCOS2DX", "Node.js", "Ruby/Perl", "项目管理", "算法工程师", "语言/视频/图形开发",
//                "数据分析", "IT硬件"};
//        String a2 [] = {"行政", "人力资源"};
//        String a3 [] = {"产品经理", "数据产品经理"};
//        String a4 [] = {"SEO/SEM", "客服","产品运营", "内容运营", "新媒体", "用户运营"};
//        String a5 [] = {"软件销售", "销售","零售", "市场营销/推广", "汽车销售", "房地产销售", "银行/保险销售","会务会展销售", "医疗"};
//        String a6 [] = {"产品运营", "管理培训生"};
//        String a7 [] = {"酒店/餐饮", "旅游策划/服务"};
//        String a8 [] = {"视觉设计", "用户体验/交互"};
//        String a9 [] = {"运输", "仓储", "采购","供应链/物流", "进出口贸易"};
//        String a10 [] = {"摄影摄像/后期", "广告设计", "市场营销/推广","主持人/主播/DJ", "创意/策划/公关","视觉管理/发行","新闻/编辑",
//                         "演员/配音/模特", "化妆/造型/服装", "会务会展","导演/编剧"};
//        String a11[] = {"通信", "技工", "生产管理","质量安全",""};


}