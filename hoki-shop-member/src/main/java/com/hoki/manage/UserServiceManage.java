package com.hoki.manage;

import com.hoki.api.entity.UserEntity;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceManage
 * Package:com.hoki.manage
 * Description:会员服务管理层
 *
 * @author :Hoki_Lin
 * @date :2020/9/4 16:52
 */
@Service
public interface UserServiceManage {
    /**
     * 注册
     *
     * @param userEntity
     */
    void regist(UserEntity userEntity);

    /**
     * 加盐: 通过手机号和密码进行加盐;
     * 当然,最好的方法是通过userId进行加盐,但是之后的认证步骤会变得繁琐。
     * 在实际开发中,有些对安全要求严格的,还会对密码用Base64进行再次加密。
     *
     * @param phone
     * @param password
     * @return
     */
    String md5PassSalt(String phone, String password);
}
