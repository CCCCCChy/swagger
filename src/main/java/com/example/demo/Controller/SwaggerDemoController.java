package com.example.demo.Controller;

import com.example.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {


    private static final Logger logger= LoggerFactory.getLogger(SwaggerDemoController.class);

        @ApiOperation(value = "根据id查询学生信息123", notes = "查询数据库中某个的学生信息456")
        @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
        @GetMapping(value = "/{id}")
        public Student getStudent(@PathVariable int id) {
            logger.info("开始查询某个学生信息");
            Student student = new Student();
            student.setId(id);
            student.setName("小黑");
            return student;
        }


}


