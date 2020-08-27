package com.cf.colorm.controller;

import com.cf.colorm.api.CommonsResult;
import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.TdFileCheckIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "库存")
@RequestMapping("colorm/storein")
public class StoreInController {

    private static Log log = LogFactory.getLog(StoreInController.class);

    @ApiOperation(value = "入仓")
    @PostMapping("/add")
    public ResponseResult add(@RequestBody TdFileCheckIn tdFileCheckIn){
        log.info(tdFileCheckIn);
        return CommonsResult.getSuccessResult("入仓成功");
    }

}
