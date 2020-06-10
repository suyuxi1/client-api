package com.niit.soft.client.api.service.impl;

import com.niit.soft.client.api.common.ResponseResult;
import com.niit.soft.client.api.domain.dto.FleaUserDto;
import com.niit.soft.client.api.domain.dto.UpdateFleaUserDto;
import com.niit.soft.client.api.domain.model.FleaUser;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.repository.FleaUserRepository;
import com.niit.soft.client.api.repository.UserAccountRepository;
import com.niit.soft.client.api.service.FleaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaUserServiceImpl.java
 * @Description TODO
 * @createTime 2020年06月09日 14:06:00
 */
@Slf4j
@Service
public class FleaUserServiceImpl implements FleaUserService {
    @Resource
    private FleaUserRepository fleaUserRepository;
    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public ResponseResult saveFleaUser(FleaUserDto fleaUserDto) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findByCardNumber(fleaUserDto.getJobNumber());
        FleaUser fleaUser = FleaUser.builder()
                .nickname(userAccountOptional.get().getNickname()).username(userAccountOptional.get().getUserName())
                .sex(userAccountOptional.get().getGender()).phoneNumber(userAccountOptional.get().getPhoneNumber())
                .jobNumber(userAccountOptional.get().getJobNumber()).avatar(userAccountOptional.get().getAvatar())
                .isDeleted(false)
                .build();
        return ResponseResult.success(fleaUserRepository.save(fleaUser));
    }

    @Override
    public ResponseResult updateFleaUser(UpdateFleaUserDto updateFleaUserDto) {
        Optional<FleaUser> fleaUserOptional = fleaUserRepository.findById(updateFleaUserDto.getPkFleaUserId());
        FleaUser fleaUser = FleaUser.builder()
                .isDeleted(fleaUserOptional.get().getIsDeleted()).jobNumber(fleaUserOptional.get().getJobNumber())
                .avatar(updateFleaUserDto.getAvatar()).phoneNumber(updateFleaUserDto.getPhoneNumber())
                .username(fleaUserOptional.get().getUsername()).nickname(updateFleaUserDto.getNickname())
                .sex(updateFleaUserDto.getSex()).pkFleaUserId(updateFleaUserDto.getPkFleaUserId())
                .build();
        return ResponseResult.success(fleaUserRepository.saveAndFlush(fleaUser));
    }
}
