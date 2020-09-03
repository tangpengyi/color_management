package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.service.TdFileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class TdFileControllerTest {

    @Autowired
    private TdFileService tdFileServiceImpl;

    @Test
    public void removeById(){
        ResponseResult responseResult = tdFileServiceImpl.removeById(3,"邱义辉");
        log.info(responseResult.getMsg());
    }

}
