package com.zephon.pub.controller;

import com.zephon.common.model.Department;
import com.zephon.common.pojo.Result;
import com.zephon.pub.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.controller
 * @date 2020/7/12 下午8:04
 * @Copyright ©
 */
@RestController
@RequestMapping("/department")
@Api(tags = "科室CRUD接口")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    @ApiOperation(value = "添加科室", notes = "")
    @ApiImplicitParam(name = "access-token", paramType = "header")
    public Result save(@RequestBody Department department) {
        try {
            departmentService.save(department);
            return new Result("添加成功", 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("添加失败", 500);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询科室", notes = "")
    @ApiImplicitParam(name = "access-token", paramType = "header")
    public Result findById(@PathVariable("id") String id) {
        try{
            Department drug = departmentService.findById(id);
            if (drug != null) {
                return new Result("查询成功", 200, drug);
            }
        }catch (Exception e){

        }
        return new Result("查询失败", 500);
    }

    @GetMapping()
    @ApiOperation(value = "查询所有科室", notes = "")
    @ApiImplicitParam(name = "access-token", paramType = "header")
    public Result findAll(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                          @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        if (page != null && pageSize != null) {
            return new Result("查询成功", 200, departmentService.findAll(page, pageSize));
        }
        List<Department> list = departmentService.findAll();
        if (list != null) {
            return new Result("查询成功", 200, list);
        }
        return new Result("查询失败", 500);
    }

    @PutMapping()
    @ApiOperation(value = "更新科室信息", notes = "")
    @ApiImplicitParam(name = "access-token", paramType = "header")
    public Result update(@RequestBody Department drug) {
        try {
            departmentService.save(drug);
            return new Result("更新成功", 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("更新失败", 500);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除科室", notes = "")
    @ApiImplicitParam(name = "access-token", paramType = "header")
    public Result delete(@PathVariable String id) {
        try {
            departmentService.deleteById(id);
            return new Result("删除成功", 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("删除失败", 500);
        }
    }
}
