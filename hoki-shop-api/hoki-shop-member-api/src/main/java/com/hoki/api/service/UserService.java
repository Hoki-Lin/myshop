package com.hoki.api.service;

import com.hoki.api.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * ClassName:UserService
 * Package:com.hoki.api.service
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/4 16:35
 */
@RequestMapping("/member")
public interface UserService {
    /**
     * 会员注册
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/regist")
    Map<String, Object> regist(@RequestBody UserEntity userEntity);
}
