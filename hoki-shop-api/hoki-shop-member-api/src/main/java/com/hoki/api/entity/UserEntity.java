package com.hoki.api.entity;

import com.hoki.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:UserEntity
 * Package:com.hoki.api.entity
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/4 16:30
 */
@Getter
@Setter
public class UserEntity extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;
}
