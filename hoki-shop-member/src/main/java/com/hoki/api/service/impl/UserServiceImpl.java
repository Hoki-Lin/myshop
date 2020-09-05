package com.hoki.api.service.impl;

import com.hoki.api.entity.UserEntity;
import com.hoki.api.service.UserService;
import com.hoki.common.api.BaseApiService;
import com.hoki.manage.UserServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName:UserServiceImpl
 * Package:com.hoki.api.service.impl
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/4 16:40
 */
@Slf4j
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {

    /**
     * 变量注入方式不被推荐,所以使用构造器注入的方式
     */
    private final UserServiceManage userServiceManage;

    @Autowired
    public UserServiceImpl(UserServiceManage userServiceManage) {
        this.userServiceManage = userServiceManage;
    }

    @Override
    public Map<String, Object> regist(@RequestBody UserEntity userEntity) {

        //简单参数校验
        if (StringUtils.isEmpty(userEntity.getUsername())) {
            return setResultParameterError("用户名不能为空");
        }

        if (StringUtils.isEmpty(userEntity.getPassword())) {
            return setResultParameterError("密码不能为空");
        }

        try {
            userServiceManage.regist(userEntity);
            return setResultSuccess();
        } catch (Exception e) {
            log.error("###regist() ERROR: ", e);
            return setResultError("注册失败!");
        }
    }
}
