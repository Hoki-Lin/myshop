package com.hoki.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:BaseRedisService
 * Package:com.hoki.common.redis
 * Description:对Redis接口进行封装
 *
 * @author :Hoki_Lin
 * @date :2020/9/1 16:48
 */
@Component
public class BaseRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置key的值
     *
     * @param key
     * @param value
     */
    public void setString(String key, String value) {
        set(key, value, null);
    }

    public void setString(String key, String value, Long timeOut) {
        set(key, value, timeOut);
    }

    public void set(String key, Object value, Long timeOut) {
        if (value != null) {
            if (value instanceof String) {
                String setValue = (String) value;
                stringRedisTemplate.opsForValue().set(key, setValue);
            }
            //设置有效期
            if (timeOut != null) {
                stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
            }
        }
    }

    /**
     * 获取key的值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 使用key删除redis信息
     * http://localhost:8762/demo/delKey?key=hoki
     *
     * @param key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }
}
