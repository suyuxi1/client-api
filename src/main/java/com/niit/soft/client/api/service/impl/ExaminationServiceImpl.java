package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.domain.vo.ExaminationVo;
import com.niit.soft.client.api.repository.ExaminationRepository;
import com.niit.soft.client.api.service.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ExaminationServiceImpl
 * @Description TODO
 * @Date 2020/6/4
 * @Version 1.0
 **/
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ExaminationRepository examinationRepository;

    @Override
    public List<ExaminationVo> selectAll(String jobNumber) {
        // 第一步：调用底层 Repository 中的查询方法，返回结果为 List<Object> 对象
        List<Object> examinationVos = examinationRepository.selectAll(jobNumber);
        // 第二步：创建 List<ExaminationVo> 对象作为将来的返回结果
        List<ExaminationVo> list = new ArrayList<>(10);
        // 第三步：遍历 List<Object> 对象，此对象中的具体值，请看本项目根路径下的 ‘object.json’文件(作为参考文件，可查看 List<Object>的返回结果)，已经处理成 JSON 数据
        for (Object obj : examinationVos) {
            Object[] rowArray = (Object[]) obj;
            /*
             第四步：依次将 rowArray 中的数据拿出来转换为 Java中的对象，并复制给我们的 examinationVo 对象
             此处需要注意 Object 转 Long的方法，不能直接强制类型转换
             */
            ExaminationVo examinationVo = ExaminationVo.builder()
                    .pkExaminationId(Long.valueOf(String.valueOf(rowArray[0])))
                    .semester((String) rowArray[1])
                    .teacherName((String) rowArray[2])
                    .startTime((Timestamp) rowArray[3])
                    .finishTime((Timestamp) rowArray[4])
                    .area((String) rowArray[5])
                    .score((Integer) rowArray[6])
                    .type((String) rowArray[7])
                    .gmtCreate((Timestamp) rowArray[8])
                    .subjectName((String) rowArray[9])
                    .clazzName((String) rowArray[10])
                    .performance((Double) rowArray[11])
                    .build();
            list.add(examinationVo);
        }
        return list;
    }
}
