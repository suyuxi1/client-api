package com.niit.soft.client.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 发送验证码
 * @Author 涛涛
 * @Date 2020/5/27 9:00
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsPhoneDto {
    //手机号
    private String phoneNumber;
}
