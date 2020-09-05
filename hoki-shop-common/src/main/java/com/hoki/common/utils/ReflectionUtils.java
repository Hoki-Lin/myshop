package com.hoki.common.utils;

//import com.hoki.common.entity.TestEntity;
import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * ClassName:ReflectionUtils
 * Package:com.hoki.common.utils
 * Description:反射工具类
 *
 * @author :Hoki_Lin
 * @date :2020/9/3 9:22
 */
@Slf4j
public class ReflectionUtils {

    /**
     * 获取当前类及其父类的所有属性
     *
     * @param obj
     * @return
     */
    public static String getWholeFields(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> clazz = obj.getClass();
        //获取当前类的所有属性(public+private)
        Field[] subFields = clazz.getDeclaredFields();
        String subField = getFields(subFields);

        //获取父类的所有属性(public+private)
        Field[] supFields = clazz.getSuperclass().getDeclaredFields();
        String supField = getFields(supFields);

        return subField + "," + supField;
    }

    /**
     * 获取当前类及其父类的所有属性的值
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static String getWholeFieldsValues(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        Class<?> clazz = obj.getClass();
        //获取当前类的所有属性(public+private)
        Field[] subFields = clazz.getDeclaredFields();
        String subField = getFieldsValues(obj, subFields);

        //获取父类的所有属性(public+private)
        Field[] supFields = clazz.getSuperclass().getDeclaredFields();
        String supField = getFieldsValues(obj, supFields);

        return subField + "," + supField;
    }


    /*
     * 获取类的属性
     *
     * @return
     */
//    public static String getInsertFields(Object obj) {
//        if (obj == null) {
//            return null;
//        }
//        //获取class文件
//        Class<?> clazz = obj.getClass();
//
//        //获取当前类的所有属性(公共属性+私有属性)
//        Field[] fields = clazz.getDeclaredFields();
//
//        //获取当前类及其父类的所有公共属性
////        Field[] fields = clazz.getFields();
//
//        //获取当前类的父类的所有公共属性
////        Field[] fields = clazz.getSuperclass().getFields();
//
//        //获取当前类的父类的所有属性(公共属性+私有属性)
////        Field[] fields = clazz.getSuperclass().getDeclaredFields();
//
//        return getFields(fields);
//    }

    /**
     * 拼接当前类的所有属性
     *
     * @param fields
     * @return
     */
    private static String getFields(Field[] fields) {
        StringBuilder sd = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sd.append(fields[i].getName());
            if (i < fields.length - 1) {
                sd.append(",");
            }
        }

        return sd.toString();
    }


    /**
     * 获取当前对象的所有属性的值
     *
     * @param obj
     * @param fields
     * @return
     * @throws IllegalAccessException
     */
    private static String getFieldsValues(Object obj, Field[] fields) throws IllegalAccessException {
        StringBuilder sd = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            //打开私有访问
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);

            //如果是String类型的话,就加单引号
            boolean flag = false;
            if (value instanceof String || value instanceof Timestamp) {
                flag = true;
            }
            if (flag) {
                sd.append("'");
                sd.append(value);
                sd.append("'");
            } else {
                sd.append(value);
            }


            if (i < fields.length - 1) {
                sd.append(",");
            }
        }

        return sd.toString();
    }

//    public static void main(String[] args) throws IllegalAccessException {
//        TestEntity testEntity = new TestEntity();
//        testEntity.setUsername("hoki");
//        testEntity.setPassword("123456");
//        testEntity.setPhone("123123123");
//        testEntity.setEmail("1111@qq.com");
//        testEntity.setId((long) 111);
//        //不传入时间戳的话,sql不完整
//        testEntity.setCreated(DateUtils.getTimestamp());
//        testEntity.setUpdated(DateUtils.getTimestamp());
//        String fields = getWholeFields(testEntity);
////        log.info(fields);
//        String values = getWholeFieldsValues(testEntity);
////        log.info(values);
//
//        //sql拼接
//        SQL sql = new SQL() {{
//            INSERT_INTO("`mb_user`");
//            VALUES(fields, values);
//        }};
//
//        log.info(sql.toString());
//    }
}
