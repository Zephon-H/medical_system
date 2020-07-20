package com.zephon.outpatient.controller;

import com.zephon.common.model.Employee;
import com.zephon.common.model.MedicalRecord;
import com.zephon.common.pojo.Result;
import com.zephon.outpatient.api.MedicalRecordApi;
import com.zephon.outpatient.service.OutpatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient.controller
 * @date 2020/7/17 上午10:12
 * @Copyright ©
 */
@RestController
@RequestMapping("/out")
@Api(tags = "门诊业务接口")
public class OutpatientController {
    @Autowired
    private MedicalRecordApi medicalRecordApi;

    @PutMapping("")
    @ApiOperation(value="药品收费", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result charge(@RequestBody MedicalRecord medicalRecord){
        medicalRecord.setPayStatus("1");
        medicalRecord.setPayTime(new Date());
        return medicalRecordApi.update(medicalRecord);
    }

    @PostMapping("")
    @ApiOperation(value="挂号", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result registration(@RequestBody MedicalRecord medicalRecord){
        Result result = medicalRecordApi.save(medicalRecord);
        Map<String,String> map = (Map<String, String>) result.getData();
        String id = map.get("id");
        Result tmp = medicalRecordApi.findById(id);
        if(tmp.getData()!=null){
            result.setData(tmp.getData());
        }
        return result;
    }
    @Autowired
    private OutpatientService outpatientService;
    @GetMapping("")
    @ApiOperation(value="根据科室查询", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findAll(@RequestParam("departId") String departId){
        try {
            List<Employee> list = outpatientService.findByDepartId(departId);
            return new Result("查询成功",200,list);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return new Result("查询失败",500);
    }
}
