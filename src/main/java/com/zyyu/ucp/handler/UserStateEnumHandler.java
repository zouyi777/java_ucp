package com.zyyu.ucp.handler;

import com.zyyu.ucp.enums.UserStateEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java枚举UserStateEnum自动转换，存取数据库
 */
@MappedTypes(value = UserStateEnum.class)
public class UserStateEnumHandler implements TypeHandler<UserStateEnum> {

    @Override
    public UserStateEnum getResult(ResultSet rs, String column) throws SQLException {
        return UserStateEnum.valueOf(rs.getInt(column));
    }

    @Override
    public UserStateEnum getResult(ResultSet rs, int i) throws SQLException {
        return UserStateEnum.valueOf(rs.getInt(i));
    }

    @Override
    public UserStateEnum getResult(CallableStatement cs, int i) throws SQLException {
        return UserStateEnum.valueOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, UserStateEnum userStateEnum, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) userStateEnum.ordinal());
    }

}