package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.service.StoreInService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "库存")
@RequestMapping("colorm/storein")
public class StoreInController {

    private static Log log = LogFactory.getLog(StoreInController.class);

    @Autowired
    private StoreInService storeInServiceImpl;

    @ApiOperation(value = "入仓")
//    @ApiImplicitParam(name = "tdFileCheckIn", value = "入仓信息",paramType = "body",required = true,dataType = "TdFileCheckIn")
    @PostMapping("/add")
    public ResponseResult add(@RequestBody StoreInVO storeInVO){
        return storeInServiceImpl.storeIn(storeInVO);
    }

}
