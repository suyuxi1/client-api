package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.dto.FleaCommentDto;
import com.niit.soft.client.api.domain.model.FleaComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FleaCommentRepositoryTest {
    @Autowired
    private FleaCommentRepository commentRepository;
    @Autowired
    private FleaUserRepository userRepository;
    @Autowired
    private FleaRewardRepository rewardRepository;
    @Test
    void increased() {
        FleaCommentDto fleaCommentDto = FleaCommentDto.builder()
                .comment("CESHISHUJUaaa")
                .reviewerId(2l)
                .userId(3l)
                .rewardId(11l)
                .build();
        FleaComment  fleaComment = FleaComment.builder()
                .comment(fleaCommentDto.getComment())
                .commentBy(userRepository.getOne(fleaCommentDto.getUserId()))
                .reviewer(userRepository.getOne(fleaCommentDto.getReviewerId()))
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .fleaReward(rewardRepository.getOne(fleaCommentDto.getRewardId()))
                .isDeleted(false)
                .build();
        System.out.println(commentRepository.save(fleaComment));
    }
}