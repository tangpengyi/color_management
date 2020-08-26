package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.service.TdFileService;
import io.swagger.annotations.Api;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
资料信息
 */
@RestController
@Api(value = "资料信息")
@RequestMapping("colorm/tdfile")
public class TdFileController {

    private static Log log = LogFactory.getLog(TdFileController.class);

    @Autowired
    private TdFileService tdFileServiceImpl;

    @PostMapping("add")
    public ResponseResult add(@RequestBody TdFile tdFile){
        return tdFileServiceImpl.add(tdFile);
    }

}
