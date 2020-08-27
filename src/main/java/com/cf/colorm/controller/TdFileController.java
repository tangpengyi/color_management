package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.service.TdFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
资料信息
 */
@RestController
@Api(tags = "色卡资料信息")
@RequestMapping("colorm/tdfile")
public class TdFileController {

    private static Log log = LogFactory.getLog(TdFileController.class);

    @Autowired
    private TdFileService tdFileServiceImpl;

    @ApiOperation(value="色卡资料新增")
    @PostMapping("add")
    public ResponseResult add(@RequestBody TdFile tdFile){
        return tdFileServiceImpl.add(tdFile);
    }

}
