package com.hoki.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ClassName:TestEntity
 * Package:com.hoki.common.entity
 * Description:@RequiredArgsConstructor
 *
 * @author :Hoki_Lin
 * @date :2020/9/3 9:58
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestEntity extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;
}
