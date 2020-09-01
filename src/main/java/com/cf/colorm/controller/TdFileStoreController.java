package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.service.StoreInService;
import com.cf.colorm.service.StoreOutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "库存")
@RequestMapping("colorm/storein")
public class TdFileStoreController {

    private static Log log = LogFactory.getLog(TdFileStoreController.class);

    @Autowired
    private StoreInService storeInServiceImpl;

    @Autowired
    private StoreOutService storeOutService;

    @ApiOperation(value = "入仓")
    @PostMapping("/add")
    public ResponseResult add(@RequestBody StoreInVO storeInVO){
        return storeInServiceImpl.storeIn(storeInVO);
    }


    @ApiOperation(value = "查询所有库存")
    @GetMapping("/get")
    public ResponseResult getAll(){
        return storeInServiceImpl.getAll();
    }

    @ApiOperation(value = "出库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "库存id",paramType = "query",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "用户姓名",paramType = "query",required = true,dataType = "String")
    })
    @GetMapping("/storeOut")
    public ResponseResult storeOut(Integer id,String userName){
        return storeOutService.storeOut(id,userName);
    }

}
