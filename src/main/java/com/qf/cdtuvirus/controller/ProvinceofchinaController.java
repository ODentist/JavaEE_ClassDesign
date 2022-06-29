package com.qf.cdtuvirus.controller;

import com.qf.cdtuvirus.dto.MapData;
import com.qf.cdtuvirus.entity.Provinceofchina;
import com.qf.cdtuvirus.service.ProvinceofchinaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Provinceofchina)表控制层
 *
 * @author makejava
 * @since 2022-06-21 09:19:20
 */
@RestController
@RequestMapping("provinceofchina")//拦截请求
public class ProvinceofchinaController {
    /**
     * 服务对象
     */
    @Resource
    private ProvinceofchinaService provinceofchinaService;


    @GetMapping
    public Map<String, Object> queryEpidemic() {
        Map<String, Integer> data = provinceofchinaService.queryEpidemiceDate();
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "success");
        result.put("data", data);
        return result;
    }

    @GetMapping("map")
    public Map<String, Object>queryMapdata(){
        //loading map data
        List<MapData> map_data=provinceofchinaService.queryMapData();
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message","success");
        result.put("data",map_data);
        return result;
    }

    @GetMapping("CumulativeConfirm")
    public Map<String, Object>CumulativeConfirm(){
       List<MapData> mapData = provinceofchinaService.queryCumulativeConfirm();
       Map<String, Object> result = new HashMap<>();
       result.put("code", 200);
       result.put("message","success");
       result.put("data",mapData);
       return result;
    }

}

