package com.zyyu.ucp.handler;

import com.zyyu.ucp.enums.CorpusCatgoryEnum;
import com.zyyu.ucp.enums.GenderEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java枚举GenderEnum自动转换，存取数据库
 */
@MappedTypes(value = CorpusCatgoryEnum.class)
public class CorpusCatgoryEnumHandler implements TypeHandler<CorpusCatgoryEnum> {

    @Override
    public CorpusCatgoryEnum getResult(ResultSet rs, String column) throws SQLException {
        return CorpusCatgoryEnum.valueOf(rs.getInt(column));
    }

    @Override
    public CorpusCatgoryEnum getResult(ResultSet rs, int i) throws SQLException {
        return CorpusCatgoryEnum.valueOf(rs.getInt(i));
    }

    @Override
    public CorpusCatgoryEnum getResult(CallableStatement cs, int i) throws SQLException {
        return CorpusCatgoryEnum.valueOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CorpusCatgoryEnum corpusCatgoryEnum, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) corpusCatgoryEnum.ordinal());
    }

}