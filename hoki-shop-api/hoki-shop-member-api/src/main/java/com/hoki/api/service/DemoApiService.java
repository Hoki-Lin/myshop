package com.hoki.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * ClassName:DemoApiService
 * Package:com.hoki.api.service
 * Description:demo服务
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 10:23
 */
@RequestMapping("/demo")
public interface DemoApiService {
    @GetMapping("/demo")
    Map<String, Object> demo();

    @GetMapping("/setKey")
    Map<String, Object> setKey(String key, String value);

    @GetMapping("/getKey")
    Map<String, Object> getKey(String key);

    @GetMapping("/delKey")
    Map<String, Object> delKey(String key);
}
