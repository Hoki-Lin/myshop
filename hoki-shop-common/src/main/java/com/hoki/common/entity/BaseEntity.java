package com.hoki.common.entity;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;


/**
 * ClassName:BaseEntity
 * Package:com.hoki.common.entity
 * Description:
 *
 * @author :Hoki_Lin
 * @date :2020/9/2 8:31
 */
@Getter
@Setter
public class BaseEntity {
    /**
     * 主键
     */
    private Long      id;
    /**
     * 创建时间
     */
    private Timestamp created;
    /**
     * 更新时间
     */
    public  Timestamp updated;


}
