package com.zephon.outpatient.api;
import com.zephon.common.pojo.Result;
import com.zephon.outpatient.pojo.Prescription;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.outpatient.api
 * @date 2020/7/21 下午5:05
 * @Copyright ©
 */
@Component
@FeignClient(value = "drug-server",contextId = "drug")
public interface DrugApi {
    @GetMapping("/prescription/{recordId}")
    Result findById(@PathVariable("recordId") String recordId);

    @PutMapping("/prescription/{recordId}")
    Result updatePrescription(@RequestBody Prescription prescription,@PathVariable("recordId") String recordId);
}