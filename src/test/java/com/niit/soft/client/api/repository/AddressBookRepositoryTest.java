package com.niit.soft.client.api.repository;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.niit.soft.client.api.domain.model.AddressBook;
import com.niit.soft.client.api.domain.model.UserAccount;
import com.niit.soft.client.api.util.CreateName;
import com.niit.soft.client.api.util.DataTypeChange;
import org.bouncycastle.crypto.tls.MACAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@SpringBootTest
class AddressBookRepositoryTest {
    @Resource
    private AddressBookRepository addressBookRepository;
    @Resource
    private UserAccountRepository userAccountRepository;

    @Test
    void getAddressBookByPhoneNumber() {

    }

    @Test
    public void batchSave() {
        Random random = new Random();
        int rand = random.nextInt(600);
        List<AddressBook> list = new ArrayList<>();
        List<UserAccount> userAccounts = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < 60; i++) {
            AddressBook addressBook = AddressBook.builder()
                    .avatar("http://www.123.jpg")
                    .phoneNumber("147521913" + i)
                    .isDeleted(false)
                    .remark(CreateName.getName())
                    .userId("1")
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .build();
            list.add(addressBook);
            String[] genders =new String[]{"男", "女"};
            UserAccount account = UserAccount.builder()
                    .avatar("http://www.123.jpg")
                    .phoneNumber("147521913" + i)
                    .isDeleted(false)
                    .userAccount("147521913" + i )
                    .Address("江苏南京")
                    .cardNumber(180233311 + (i+19))
                    .clazzId(1)
                    .gender(genders[new Random().nextInt(2)])
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .jobNumber("18023331" + (i+19))
                    .userName(CreateName.getName())
                    .role("1")
                    .pkUserAccountId(String.valueOf(n++))
                    .nickname("test测试" + i)
                    .password("12323123")
                    .status(true)
                    .build();
            userAccounts.add(account);
        }
        addressBookRepository.saveAll(list);
        //userAccountRepository.saveAll(userAccounts);
    }
}