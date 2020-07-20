package com.zephon.doctor.controller;

import com.zephon.common.model.MedicalRecord;
import com.zephon.common.pojo.Result;
import com.zephon.doctor.api.DrugApi;
import com.zephon.doctor.pojo.Prescription;
import com.zephon.doctor.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.controller
 * @date 2020/7/13 下午5:01
 * @Copyright ©
 */
@RestController
@RequestMapping("/prescription")
@Api(tags = "医生站业务接口")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private DrugApi drugApi;

    @PostMapping("")
    @ApiOperation(value="添加处方", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result save(@RequestBody Prescription prescription){
        try {
            prescriptionService.save(prescription);
            return new Result("添加成功",200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("添加失败",500);
        }
    }

    @GetMapping("drug/{id}")
    @ApiOperation(value="根据ID查询药品", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findById(@PathVariable("id") String id){
        return drugApi.findById(id);
    }

}
