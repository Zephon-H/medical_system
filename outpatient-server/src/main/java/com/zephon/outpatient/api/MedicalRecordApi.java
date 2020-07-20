package com.zephon.outpatient.api;

import com.zephon.common.model.MedicalRecord;
import com.zephon.common.pojo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient.api
 * @date 2020/7/17 上午10:16
 * @Copyright ©
 */
@Component
@FeignClient(value = "public-server",contextId = "medicalrecord")
public interface MedicalRecordApi {
    @PutMapping("/record/")
    Result update(@RequestBody MedicalRecord medicalRecord);

    @PostMapping("/record/")
    Result save(@RequestBody MedicalRecord medicalRecord);

    @GetMapping("/record/{id}")
    Result findById(@PathVariable(value = "id") String id);

}