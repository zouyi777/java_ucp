package com.zyyu.ucp.handler;

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
@MappedTypes(value = GenderEnum.class)
public class GenderEnumHandler implements TypeHandler<GenderEnum> {

    @Override
    public GenderEnum getResult(ResultSet rs, String column) throws SQLException {
        return GenderEnum.valueOf(rs.getInt(column));
    }

    @Override
    public GenderEnum getResult(ResultSet rs, int i) throws SQLException {
        return GenderEnum.valueOf(rs.getInt(i));
    }

    @Override
    public GenderEnum getResult(CallableStatement cs, int i) throws SQLException {
        return GenderEnum.valueOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, GenderEnum genderEnum, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) genderEnum.getIndex().intValue());
    }

}