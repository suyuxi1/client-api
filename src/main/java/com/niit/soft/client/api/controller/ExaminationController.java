package com.niit.soft.client.api.controller;

import com.niit.soft.client.api.domain.dto.JobNumberDto;
import com.niit.soft.client.api.domain.vo.ExaminationVo;
import com.niit.soft.client.api.service.ExaminationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ExaminationController
 * @Description 考务管理控制器
 * @Date 2020/6/4
 * @Version 1.0
 **/
@RestController
@RequestMapping("/examination")
public class ExaminationController {

    @Resource
    private ExaminationService examinationService;

    @PostMapping("/jobNumber")
    public List<ExaminationVo> selectAll(@RequestBody JobNumberDto jobNumberDto) {
        return examinationService.selectAll(jobNumberDto.getJobNumber());
    }

}
