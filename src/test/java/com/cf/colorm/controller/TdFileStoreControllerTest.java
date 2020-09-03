package com.cf.colorm.controller;


import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.service.StoreInService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
public class TdFileStoreControllerTest {

    @Autowired
    private StoreInService storeInServiceImpl;

    @Test
    public void add(){
        StoreInVO storeInVO = new StoreInVO();
        storeInVO.setColorNo("1002");
        storeInVO.setAddress("A003");

        ResponseResult responseResult = storeInServiceImpl.storeIn(storeInVO);
        log.info(responseResult.getCode()+""+responseResult.getMsg());
//        Assert.assertEquals(responseResult.getCode(),200);
    }

}
