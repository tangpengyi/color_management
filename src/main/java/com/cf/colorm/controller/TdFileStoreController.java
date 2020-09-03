package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.StoreInVO;
import com.cf.colorm.entity.StoreOutVO;
import com.cf.colorm.service.FileStoreService;
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

    @Autowired
    private StoreInService storeInServiceImpl;

    @Autowired
    private StoreOutService storeOutService;

    @Autowired
    private FileStoreService fileStoreServiceImpl;

    @ApiOperation(value = "入仓")
    @PostMapping("/add")
    public ResponseResult add(@RequestBody StoreInVO storeInVO){
        return storeInServiceImpl.storeIn(storeInVO);
    }

    @ApiOperation(value = "查询所有库存")
    @GetMapping("/getAll")
    public ResponseResult getAll(){
        return storeInServiceImpl.getAll();
    }

    @ApiOperation(value = "根据色号查询库存")
    @ApiImplicitParam(name = "colorNo", value = "色号",paramType = "query",required = true,dataType = "String")
    @GetMapping("getFileStoreByColorNo")
    public ResponseResult getFileStoreByColorNo(String colorNo){
        return fileStoreServiceImpl.getFileStoreByColorNo(colorNo);
    }

    @ApiOperation(value = "出库")
    @GetMapping("/storeOut")
    public ResponseResult storeOut(@RequestBody StoreOutVO storeOutVO){
        return storeOutService.storeOut(storeOutVO);
    }

}
