package com.zephon.outpatient.controller;

import com.zephon.common.model.Employee;
import com.zephon.common.model.MedicalRecord;
import com.zephon.common.pojo.Result;
import com.zephon.outpatient.api.DrugApi;
import com.zephon.outpatient.api.MedicalRecordApi;
import com.zephon.outpatient.pojo.Prescription;
import com.zephon.outpatient.service.OutpatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private DrugApi drugApi;

    @GetMapping("/{recordId}")
    @ApiOperation(value="根据病历ID查询处方", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findById(@PathVariable("recordId") String recordId){
        return drugApi.findById(recordId);
    }

    @PutMapping("")
    @ApiOperation(value="药品收费", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result charge(@RequestBody MedicalRecord medicalRecord){
        String id = medicalRecord.getId();
        outpatientService.updateMedicalRecord(id);
        return new Result("修改成功",200);
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

    @PutMapping("/{preId}")
    @ApiOperation(value="更新处方信息", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result updatePrescription(@RequestBody Prescription prescription,@PathVariable("preId") String preId){
        if(!StringUtils.isBlank(preId)){
            prescription.setRecordId(preId);
        }
        return drugApi.updatePrescription(prescription,preId);
    }
}
