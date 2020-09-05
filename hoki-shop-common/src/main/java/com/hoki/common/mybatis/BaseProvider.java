package com.hoki.common.mybatis;

import com.hoki.common.utils.ReflectionUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * ClassName:BaseProvider
 * Package:com.hoki.common.mybatis
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/3 9:03
 */
public class BaseProvider {

    public String save(Map<String, Object> map) throws IllegalAccessException {
        //实体类
        Object obj = map.get("obj");
        //表名称
        String table = (String) map.get("table");
        //通过反射机制生成sql
        SQL sql = new SQL() {{
            INSERT_INTO(table);
            VALUES(ReflectionUtils.getWholeFields(obj), ReflectionUtils.getWholeFieldsValues(obj));
        }};

        return sql.toString();
    }
}
