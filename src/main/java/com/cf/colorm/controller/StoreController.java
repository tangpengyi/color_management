package com.cf.colorm.controller;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.service.StoreServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "仓库")
@RequestMapping("colorm/store")
public class StoreController {

    @Autowired
    private StoreServer storeServerImpl;

    @ApiOperation(value="查询仓库", notes = "根据id查询仓库信息")
    @ApiImplicitParam(name = "id", value = "仓库id",paramType = "query",required = true,dataType = "int")
    @GetMapping("/get")
    public ResponseResult getStore(int id){
        return CommonsResult.getSuccessResult("查询成功",storeServerImpl.findStoreByid(id));
    }

}
