package com.hoki.api.service.impl;

import com.hoki.api.service.DemoApiService;
import com.hoki.common.api.BaseApiService;
import com.hoki.common.redis.BaseRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName:DemoApiServiceImpl
 * Package:com.hoki.api.service.impl
 * Description:eureka服务启动后,再启动member模块,访问http://localhost:8762/demo/demo
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 10:27
 */
@RestController
public class DemoApiServiceImpl extends BaseApiService implements DemoApiService {

    /**
     * 构造器方法注入
     */
    private final BaseRedisService baseRedisService;

    @Autowired
    public DemoApiServiceImpl(BaseRedisService baseRedisService) {
        this.baseRedisService = baseRedisService;
    }

    @Override
    public Map<String, Object> demo() {
        return setResultSuccess();
    }

    /**
     * 使用redis要先启动redis服务器
     * http://localhost:8762/demo/setKey?key=hoki&value=HongqinLin
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Map<String, Object> setKey(String key, String value) {
        baseRedisService.setString(key, value);
        return setResultSuccess();
    }

    /**
     * http://localhost:8762/demo/getKey?key=name
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, Object> getKey(String key) {
        String value = baseRedisService.get(key);
        return setResultSuccessData(value);
    }

    /**
     * 删除指定key
     * http://localhost:8762/demo/delKey?key=name
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, Object> delKey(String key) {
        baseRedisService.delete(key);
        return setResultSuccess();
    }
}
