package com.springboot.study.common.config;

import com.springboot.study.example.entity.User;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

//声明JDBCtype为整型
@MappedJdbcTypes(JdbcType.INTEGER)
//声明JAVAtype为SexEnum
@MappedTypes(value = SexEnum.class)
public class SexHandler extends BaseTypeHandler<SexEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }


    /**
     * 通过列名读取性别
     *
     * @param resultSet 数据库查询的返回信息
     * @param s         列名
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        if (anInt != 1 && anInt != 2) {
            return null;
        }
        return SexEnum.getEnumByid(anInt);
    }


    /**
     * 通过下标读取性别
     *
     * @param resultSet 数据库查询数据返回结果
     * @param i         第几列
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int anInt = resultSet.getInt(i);
        if (anInt != 1 && anInt != 2) {
            return null;
        }
        return SexEnum.getEnumByid(anInt);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
