package com.zephon.drug.controller;

import com.zephon.common.pojo.Result;
import com.zephon.drug.pojo.Prescription;
import com.zephon.drug.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiOperation(value="查询所有已付款的处方信息", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findAllPrescription(){
        List<Prescription> list = prescriptionService.findAll();
        return new Result("查询成功",200,list);
    }
    @GetMapping("/{recordId}")
    @ApiOperation(value="根据recordId查询处方", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findById(@PathVariable("recordId")String recordId){
        try {
            Prescription p =  prescriptionService.findByRecordId(recordId);
            return new Result("查询成功",200,p);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return new Result("查询失败",500);
    }

    @PutMapping("/{recordId}")
    @ApiOperation(value="更新处方", notes="",hidden = true)
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result updatePrescription(@RequestBody Prescription prescription,@PathVariable("recordId") String recordId){
        try {
            prescriptionService.updatePrescription(prescription,recordId);
            return new Result("更新成功",200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result("更新失败",500);
    }
}
