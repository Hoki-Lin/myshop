package com.hoki.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:BaseDao
 * Package:com.hoki.common.mybatis
 * Description: 对数据库操作的封装
 *
 * @author :Hoki_Lin
 * @date :2020/9/3 8:55
 */
public interface BaseDao {

    @InsertProvider(type = BaseProvider.class, method = "save")
    public void save(@Param("obj") Object obj, @Param("table") String table);

}
