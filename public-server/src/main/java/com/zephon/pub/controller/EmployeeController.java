package com.zephon.pub.controller;

import com.zephon.common.model.Employee;
import com.zephon.common.pojo.Result;
import com.zephon.pub.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.controller
 * @date 2020/7/12 下午6:41
 * @Copyright ©
 */
@RestController
@RequestMapping("/employee")
@Api(tags = "员工CRUD接口")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("")
    @ApiOperation(value="添加员工", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result save(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
            return new Result("添加成功",200);
        } catch (Exception e) {
            if(e.getMessage().equals("用户已存在")){
                return new Result("用户已存在",500);
            }
            e.printStackTrace();
            return new Result("添加失败",500);
        }
    }
    @GetMapping("/{id}")
    @ApiOperation(value="根据ID查询员工", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findById(@PathVariable("id") String id){
        try {
            Employee employee = employeeService.findById(id);
            if(employee!=null){
                return new Result("查询成功",200,employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result("查询失败",500);
    }
    @GetMapping()
    @ApiOperation(value="查询所有员工", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result findAll(@RequestParam(value = "page",defaultValue = "1",required = false)Integer page,
                          @RequestParam(value = "pageSize",defaultValue = "10",required = false)Integer pageSize){
        if(page!=null&&pageSize!=null){
            return new Result("查询成功",200,employeeService.findAll(page,pageSize));
        }
        List<Employee> list = employeeService.findAll();
        if(list!=null){
            return new Result("查询成功",200,list);
        }
        return new Result("查询失败",500);
    }
    @PutMapping("")
    @ApiOperation(value="更新员工信息", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result update(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
            return new Result("更新成功",200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("更新失败",500);
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value="删除员工", notes="")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result delete(@PathVariable String id){
        try {
            employeeService.deleteById(id);
            return new Result("删除成功",200);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("删除失败",500);
        }
    }
}
