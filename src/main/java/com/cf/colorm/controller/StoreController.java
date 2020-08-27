package com.cf.colorm.controller;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.service.StoreServer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation("仓库")
@RequestMapping("colorm/store")
public class StoreController {

    @Autowired
    private StoreServer storeServerImpl;

    @GetMapping("/get")
    public ResponseResult getStore(@ApiParam("仓库id") int id){
        return CommonsResult.getSuccessResult("查询成功",storeServerImpl.findStoreByid(id));
    }

}
