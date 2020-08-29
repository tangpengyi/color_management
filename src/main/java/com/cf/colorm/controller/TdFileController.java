package com.cf.colorm.controller;

import com.cf.colorm.api.ResponseResult;
import com.cf.colorm.entity.TdFile;
import com.cf.colorm.service.TdFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
//    @ApiImplicitParam(name = "tdFile", value = "颜色信息",paramType = "body",required = true,dataType = "TdFile")
    @PostMapping("add")
    public ResponseResult add(@RequestBody TdFile tdFile){
        return tdFileServiceImpl.add(tdFile);
    }

    @ApiOperation(value="根据色号查询",notes = "根据色号查询色")
    @ApiImplicitParam(name = "colorNo", value = "色号",paramType = "query",required = true,dataType = "String")
    @GetMapping("/get")
    public ResponseResult get(String colorNo){
        return tdFileServiceImpl.findColorNameByNo(colorNo);
    }

    @ApiOperation(value="查询",notes = "条件查询色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "条件",paramType = "query",required = true,dataType = "String"),
            @ApiImplicitParam(name = "param", value = "参数",paramType = "query",required = true,dataType = "String")
    })
    @GetMapping("/getByCondition")
    public ResponseResult get(String condition,String param){
        return tdFileServiceImpl.findColorByCondition(condition,param);
    }

    @ApiOperation(value="查询所有颜色信息",notes = "查询所有颜色信息")
    @GetMapping("/getAll")
    public ResponseResult getAll(){
        return tdFileServiceImpl.findAll();
    }

    @ApiOperation(value="查询所有颜色信息",notes = "查询所有颜色信息")
    @PostMapping("/modity")
    public ResponseResult modityTdFile(@RequestBody TdFile tdFile){
        return tdFileServiceImpl.modityTdFile(tdFile);
    }
}
