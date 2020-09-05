package com.hoki.manage.impl;

import com.hoki.api.entity.UserEntity;
import com.hoki.common.utils.DateUtils;
import com.hoki.common.utils.Md5Utils;
import com.hoki.constant.DbTableNameConstant;
import com.hoki.dao.UserDao;
import com.hoki.manage.UserServiceManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceManageImpl
 * Package:com.hoki.manage.impl
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/4 16:54
 */
@Service
public class UserServiceManageImpl implements UserServiceManage {

    private final UserDao userDao;

    @Autowired
    public UserServiceManageImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void regist(UserEntity userEntity) {
        userEntity.setCreated(DateUtils.getTimestamp());
        userEntity.setUpdated(DateUtils.getTimestamp());
        //对密码进行加盐
        String phone = userEntity.getPhone();
        String password = userEntity.getPassword();
        userEntity.setPassword(md5PassSalt(phone, password));
        userDao.save(userEntity, DbTableNameConstant.TABLE_MB_USER);
    }

    @Override
    public String md5PassSalt(String phone, String password) {
        return Md5Utils.md5(phone + password);
    }
}
