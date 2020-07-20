package com.zephon.doctor.api;

import com.zephon.common.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.doctor.api
 * @date 2020/7/16 上午10:18
 * @Copyright ©
 */
@Component
@FeignClient(value = "public-server",contextId = "drug")
public interface DrugApi {
    @GetMapping("/drug/{id}")
    Result findById(@PathVariable("id") String id);
}
