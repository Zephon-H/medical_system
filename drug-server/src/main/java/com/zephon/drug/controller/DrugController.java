package com.zephon.drug.controller;

import com.zephon.common.pojo.Result;
import com.zephon.drug.pojo.Prescription;
import com.zephon.drug.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.drug.controller
 * @date 2020/7/17 下午2:18
 * @Copyright ©
 */
@RestController
@RequestMapping("/prescription")
@Api(tags = "药房发药业务接口")
public class DrugController {
    @Autowired
    private PrescriptionService prescriptionService;
    @GetMapping("")
    @ApiOperation(value="查询所有处方信息", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findAllPrescription(){
        List<Prescription> list = prescriptionService.findAll();
        return new Result("查询成功",200,list);
    }
}
