package com.zephon.pub.controller;

import com.zephon.common.model.Employee;
import com.zephon.common.pojo.Result;
import com.zephon.pub.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.pub.controller
 * @date 2020/7/12 上午9:51
 * @Copyright ©
 */
@RestController
@Api(tags = "登录接口")
@RefreshScope
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @ApiOperation(value="登录", notes="")
    @ResponseHeader(name="access-token",description = "token")
    @PostMapping("/login")
    public Result login(@ApiParam("用户名和密码") @RequestBody Employee condition, HttpServletResponse response){
        try {
            Employee employee = employeeService.authLogin(condition);
            if(employee!=null){
                response.setHeader("id",employee.getId());
                response.setHeader("username",employee.getUsername());
                return new Result("登录成功",200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result("登录失败",401);
    }
    @ApiOperation(value="注册", notes="")
    @PostMapping("/register")
    public Result register(@RequestBody Employee employee){
        try {
            employeeService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("注册失败",401);
        }
        return new Result("注册成功",200);
    }

    @Value("${spring.profiles.active}")
    private String env;
    @Value("${config.info}")
    private String info;
    @GetMapping("/test")
    @ApiImplicitParam(name="access-token",paramType = "header")
    public Result test(){
        return new Result(env+"-"+info,200);
    }
}
