package com.qf.cdtuvirus.controller;

import com.qf.cdtuvirus.dto.PatientInfo;
import com.qf.cdtuvirus.entity.Patient;
import com.qf.cdtuvirus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (Patient)表控制层
 *
 * @author makejava
 * @since 2022-06-21 09:19:19
 * simulate a request ,url: http:8080/patient
 * 拦截请求
 * 获取请求参数
 * 调用服务
 * 返回参数json
 * restcontroller = controller+ResponseBody
 * get---->search
 * post--->insert
 * put---->change(all)
 * patch-->change(section)
 * delete->delete
 */

//controller was scanned by spring
@RestController
@RequestMapping("patient")
public class PatientController {
    @GetMapping("query")
    public String query(){
        return "o";
    }
    @PostMapping("insert")
    public String insert(){
        return "7";
    }
    @GetMapping("{id}/{name}")
    public Map<String, Object> queryByConditions(@PathVariable int id, @PathVariable String name){
        HashMap<String, Object> result = new HashMap<>();
        result.put("data",id);
        result.put("name",name);
        return result;
    }
/*
* "id":1,
* "country":"China",
* "province":"四川“
* */
    @PostMapping
    public Map<String, Object> insert(@RequestBody Patient patient){
        HashMap<String, Object> result = new HashMap<>();
        result.put("data",patient);
        return result;
    }

    @Autowired//注入服务对象
    private PatientService patientService;
    public Map<String, Object> putPatient(@RequestBody PatientInfo patientInfo){
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",201);
        result.put("message","unknow flaut");
        result.put("data",1);
        return result;
    }
}

